package io.paulocosta.themoviedb.ui.main;

import android.databinding.ObservableField;

import io.paulocosta.themoviedb.data.model.api.MovieResponse;

/**
 * Created by paulocosta on 02/02/18.
 */

public class MovieItemViewModel {

    private MovieResponse movieResponse;

    public ObservableField<String> originalTitle;

    public MovieItemViewModel(MovieResponse movieResponse) {
        this.movieResponse = movieResponse;
        this.originalTitle = new ObservableField<>(movieResponse.getOriginalTitle());
    }

}
