package io.paulocosta.themoviedb.data.remote;

import java.util.List;

import io.paulocosta.themoviedb.data.model.api.ApiResponse;
import io.paulocosta.themoviedb.data.model.db.Genre;
import io.reactivex.Single;


public interface ApiHelper {

    Single<ApiResponse> fetchUpcomingMovies(int page);

    Single<ApiResponse> discoverUpcomingMovies(int page);

    Single<ApiResponse> searchMovies(int page, String searchQuery);

    Single<List<Genre>> fetchGenres();

}
