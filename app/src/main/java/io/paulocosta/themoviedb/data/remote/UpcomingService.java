package io.paulocosta.themoviedb.data.remote;


import io.paulocosta.themoviedb.data.model.api.ApiResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UpcomingService {

    @GET("/3/movie/upcoming")
    Single<ApiResponse> getUpcomingMovies(@Query("page") final int page);

    @GET(value = "/3/search/movie")
    Single<ApiResponse> searchMovies(@Query(value = "page") int page,
                                     @Query(value = "query") String search,
                                     @Query(value = "primary_release_year") int year);
}