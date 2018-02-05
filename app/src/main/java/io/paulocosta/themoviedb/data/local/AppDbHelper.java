package io.paulocosta.themoviedb.data.local;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.paulocosta.themoviedb.data.model.db.Genre;
import io.paulocosta.themoviedb.data.model.db.Movie;
import io.reactivex.Observable;
import io.reactivex.Single;

@Singleton
public class AppDbHelper implements DbHelper {

    private final AppDatabase appDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public Single<List<Movie>> getDBMovies() {
        return Single.fromCallable(() -> appDatabase.getMovieDao().getAllMovies());
    }

    @Override
    public Single<Boolean> insertGenres(List<Genre> genres) {
        return Single.fromCallable(() -> {
            appDatabase.getGenreDao().insertAll(genres);
            return true;
        });
    }

    @Override
    public Single<Boolean> insertMovies(List<Movie> movies) {
        MovieGenreJoinDao movieGenreJoinDao = appDatabase.getMovieGenreJoinDao();
        return Observable.fromIterable(movies)
                .toList()
                .flatMap(m -> {
                   appDatabase.getMovieDao().insertAll(m);
                   return Observable.fromIterable(m).toList();
                })
                .toObservable()
                .flatMap(Observable::fromIterable)
                .map(m -> {
                    for (Integer i : m.getGenreIds()) {
                        movieGenreJoinDao.insert(new MovieGenreJoin(m.getId(), i));
                    }
                    return true;
                })
                .toList()
                .flatMap(l -> Observable.just(true).single(true));
    }

    @Override
    public Single<List<Genre>> getDBMovieGenres(int movieId) {
        return Single.fromCallable(() -> appDatabase.getMovieGenreJoinDao().getMovieGenres(movieId));
    }

}
