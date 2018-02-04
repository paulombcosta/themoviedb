package io.paulocosta.themoviedb.data.remote;

import javax.inject.Inject;

import io.paulocosta.themoviedb.data.model.api.ApiResponse;
import io.reactivex.Single;

/**
 * Created by paulocosta on 02/02/18.
 */

public class AppApiHelper implements ApiHelper {

    private final UpcomingService upcomingService;

    @Inject
    public AppApiHelper(final UpcomingService upcomingService) {
        this.upcomingService = upcomingService;
    }

    @Override
    public Single<ApiResponse> getUpcomingMovies(int page) {
        return upcomingService.getUpcomingMovies(page);
    }
}
