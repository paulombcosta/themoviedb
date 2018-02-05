package io.paulocosta.themoviedb.ui.movie;

import io.paulocosta.themoviedb.data.model.db.Movie;


public interface MovieNavigator {

    void openMovieDetail(Movie movie);

}
