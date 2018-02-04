package io.paulocosta.themoviedb.ui.movie.detail;

import android.databinding.ObservableField;

import io.paulocosta.themoviedb.data.DataManager;
import io.paulocosta.themoviedb.data.model.db.Movie;
import io.paulocosta.themoviedb.ui.base.BaseViewModel;

/**
 * Created by paulocosta on 03/02/18.
 */

public class MovieDetailViewModel extends BaseViewModel {

    public ObservableField<String> originalTitle;
    public ObservableField<String> poster;
    public ObservableField<String> overview;
    public ObservableField<String> releaseDate;


    public MovieDetailViewModel(DataManager dataManager) {
        super(dataManager);
        originalTitle = new ObservableField<>("");
        poster = new ObservableField<>("");
        overview = new ObservableField<>("");
        releaseDate = new ObservableField<>("");

    }

    public void setMovie(Movie movie) {
        originalTitle.set(movie.getOriginalTitle());
        poster.set(movie.getPosterPath());
        overview.set(movie.getOverview());
        releaseDate.set(movie.getReleaseDate());
    }

    // name, poster, genre, overview release date

}
