package io.paulocosta.themoviedb.ui.movie.detail;

import android.databinding.ObservableField;
import android.util.Log;

import io.paulocosta.themoviedb.data.DataManager;
import io.paulocosta.themoviedb.data.model.db.Genre;
import io.paulocosta.themoviedb.data.model.db.Movie;
import io.paulocosta.themoviedb.ui.base.BaseViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MovieDetailViewModel extends BaseViewModel {

    public ObservableField<String> originalTitle;
    public ObservableField<String> poster;
    public ObservableField<String> overview;
    public ObservableField<String> releaseDate;
    public ObservableField<String> genres;


    public MovieDetailViewModel(DataManager dataManager) {
        super(dataManager);
        originalTitle = new ObservableField<>("");
        poster = new ObservableField<>("");
        overview = new ObservableField<>("");
        releaseDate = new ObservableField<>("");
        genres = new ObservableField<>("");
    }

    public void fetchMovieGenres(int movieId) {
        getDataManager().getDBMovieGenres(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(genres -> {
                    StringBuilder genresString = new StringBuilder();
                    for (Genre g : genres) {
                        genresString.append(g.getName()).append(" ");
                    }
                    this.genres.set(genresString.toString());
                });
    }

    public void setMovie(Movie movie) {
        originalTitle.set(movie.getOriginalTitle());
        poster.set(movie.getPosterPath());
        overview.set(movie.getOverview());
        releaseDate.set(movie.getReleaseDate());
        fetchMovieGenres(movie.getId());
    }

    // name, poster, genre, overview release date

}
