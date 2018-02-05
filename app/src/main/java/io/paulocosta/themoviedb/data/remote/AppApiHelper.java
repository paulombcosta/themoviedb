package io.paulocosta.themoviedb.data.remote;

import android.text.format.DateFormat;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.paulocosta.themoviedb.data.model.api.ApiResponse;
import io.paulocosta.themoviedb.data.model.db.Genre;
import io.reactivex.Single;


public class AppApiHelper implements ApiHelper {

    private final UpcomingService upcomingService;

    @Inject
    public AppApiHelper(final UpcomingService upcomingService) {
        this.upcomingService = upcomingService;
    }

    @Override
    public Single<ApiResponse> fetchUpcomingMovies(int page) {
        String minDate = getCurrentDateFormatted();
        return upcomingService.discoverUpcomingMovies(page, minDate, minDate);
    }

    @Override
    public Single<ApiResponse> searchMovies(int page, String searchQuery) {
        return upcomingService.searchMovies(page, searchQuery);
    }

    @Override
    public Single<List<Genre>> fetchGenres() {
        return upcomingService.getMovieGenres()
                .map(r -> r.getGenres());
    }

    private String getCurrentDateFormatted() {
        return DateFormat.format("yyyy-MM-dd", new Date()).toString();
    }

}
