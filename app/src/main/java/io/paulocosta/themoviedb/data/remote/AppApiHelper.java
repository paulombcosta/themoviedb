package io.paulocosta.themoviedb.data.remote;

import javax.inject.Inject;

import io.paulocosta.themoviedb.data.model.api.UpcomingResponse;
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
    public Single<UpcomingResponse> getUpcomingMovies() {
        return upcomingService.getUpcomingMovies(1);
    }
}
