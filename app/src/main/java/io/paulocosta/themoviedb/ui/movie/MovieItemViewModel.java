package io.paulocosta.themoviedb.ui.movie;

import android.databinding.ObservableField;

import io.paulocosta.themoviedb.data.model.db.Movie;

/**
 * Created by paulocosta on 02/02/18.
 */

public class MovieItemViewModel {

    private Movie movie;

    public ObservableField<String> originalTitle;
    public ObservableField<String> overview;
    public ObservableField<String> posterPath;

    public MovieItemClickListener listener;

    public MovieItemViewModel(Movie movie, MovieItemClickListener listener) {
        this.movie = movie;
        this.originalTitle = new ObservableField<>(movie.getOriginalTitle());
        this.overview = new ObservableField<>(movie.getOverview());
        this.posterPath = new ObservableField<>(movie.getPosterPath());
        this.listener = listener;
    }

    public interface MovieItemClickListener {
        void onClick(Movie movie);
    }

    public void onItemClick() {
        listener.onClick(movie);
    }

}