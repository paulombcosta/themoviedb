package io.paulocosta.themoviedb.data.remote;


import io.paulocosta.themoviedb.data.model.api.UpcomingResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UpcomingService {

    @GET("/3/movie/upcoming")
    Single<UpcomingResponse> getUpcomingMovies(@Query("page") final int page);

//    @GET("/3/search/movie?sort_by=popularity.desc")
//    Observable<List<Movie>> searchPopularMovies(@Query("page") final int page,
//                                                @Query("query") final String query);
}