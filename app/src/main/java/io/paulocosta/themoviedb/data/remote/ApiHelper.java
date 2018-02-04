package io.paulocosta.themoviedb.data.remote;

import io.paulocosta.themoviedb.data.model.api.ApiResponse;
import io.reactivex.Single;

/**
 * Created by paulocosta on 02/02/18.
 */

public interface ApiHelper {

    Single<ApiResponse> getUpcomingMovies(int page);

}
