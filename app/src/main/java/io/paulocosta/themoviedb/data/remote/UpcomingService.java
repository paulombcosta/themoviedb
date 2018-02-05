package io.paulocosta.themoviedb.data.remote;


import io.paulocosta.themoviedb.data.model.api.ApiResponse;
import io.paulocosta.themoviedb.data.model.api.GenreApiResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UpcomingService {

    @GET("/3/discover/movie?sort_by=release_date.asc")
    Single<ApiResponse> discoverUpcomingMovies(@Query("page") int page,
                                              @Query("release_date.gte") String dateGTE);

    @GET("/3/movie/upcoming")
    Single<ApiResponse> getUpcomingMovies(@Query("page") final int page);

    @GET(value = "/3/search/movie")
    Single<ApiResponse> searchMovies(@Query(value = "page") int page,
                                     @Query(value = "query") String search);

    @GET(value = "/3/genre/movie/list")
    Single<GenreApiResponse> getMovieGenres();


}