package io.paulocosta.themoviedb.data.remote;

import java.util.List;

import javax.inject.Inject;

import io.paulocosta.themoviedb.data.model.api.MovieResponse;
import io.reactivex.Single;

/**
 * Created by paulocosta on 02/02/18.
 */

public class AppApiHelper implements ApiHelper {

    private final MoviesService moviesService;

    @Inject
    public AppApiHelper(final MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @Override
    public Single<List<MovieResponse>> getMovies() {
        return null;
    }

}
