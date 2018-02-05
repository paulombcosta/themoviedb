package io.paulocosta.themoviedb.data;

import java.util.List;

import javax.inject.Inject;

import io.paulocosta.themoviedb.data.local.DbHelper;
import io.paulocosta.themoviedb.data.model.api.ApiResponse;
import io.paulocosta.themoviedb.data.model.db.Genre;
import io.paulocosta.themoviedb.data.model.db.Movie;
import io.paulocosta.themoviedb.data.remote.ApiHelper;
import io.reactivex.Observable;
import io.reactivex.Single;

public class AppDataManager implements DataManager {

    private final DbHelper dbHelper;
    private final ApiHelper apiHelper;


    @Inject
    public AppDataManager(DbHelper dbHelper, ApiHelper apiHelper) {
        this.dbHelper = dbHelper;
        this.apiHelper = apiHelper;
    }

    @Override
    public Single<ApiResponse> fetchUpcomingMovies(int page) {
        return apiHelper.fetchUpcomingMovies(page);
    }

    @Override
    public Single<ApiResponse> searchMovies(int page, String searchQuery) {
        return apiHelper.searchMovies(page, searchQuery);
    }

    @Override
    public Single<List<Genre>> fetchGenres() {
        return apiHelper.fetchGenres();
    }

    @Override
    public Single<List<Movie>> getDBMovies() {
        return null;
    }

    @Override
    public Single<Boolean> insertGenres(List<Genre> genres) {
        return dbHelper.insertGenres(genres);
    }

    @Override
    public Single<Boolean> insertMovies(List<Movie> movies) {
        return dbHelper.insertMovies(movies);
    }

    @Override
    public Single<Boolean> fetchAndInsertGenres() {
        return apiHelper.fetchGenres()
                .flatMap(genres -> {
                    return dbHelper.insertGenres(genres);
                });
    }

    @Override
    public Single<List<Movie>> fetchAndInsertMovies(int page) {
        return apiHelper.fetchUpcomingMovies(page)
                .flatMap(r -> {
                    dbHelper.insertMovies(r.getResults()).subscribe();
                    return Observable.fromIterable(r.getResults()).toList();
                });
    }

}
