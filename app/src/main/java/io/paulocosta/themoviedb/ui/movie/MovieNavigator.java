package io.paulocosta.themoviedb.ui.movie;

import io.paulocosta.themoviedb.data.model.db.Movie;

/**
 * Created by paulocosta on 04/02/18.
 */

public interface MovieNavigator {

    void openMovieDetail(Movie movie);

}
