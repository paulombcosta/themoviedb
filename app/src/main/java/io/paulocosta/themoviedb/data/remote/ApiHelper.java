package io.paulocosta.themoviedb.data.remote;

import java.util.List;

import io.paulocosta.themoviedb.data.model.api.MovieResponse;
import io.reactivex.Single;

/**
 * Created by paulocosta on 02/02/18.
 */

public interface ApiHelper {

    Single<List<MovieResponse>> getMovies();

}
