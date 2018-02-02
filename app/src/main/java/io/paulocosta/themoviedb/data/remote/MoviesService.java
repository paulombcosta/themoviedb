package io.paulocosta.themoviedb.data.remote;


import java.util.List;

import io.paulocosta.themoviedb.data.model.api.MovieResponse;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesService {

    @GET("/3/discover/movie?sort_by=popularity.desc")
    Single<List<MovieResponse>> getPopularMovies(@Query("page") final int page);

    @GET("/3/search/movie?sort_by=popularity.desc")
    Observable<List<MovieResponse>> searchPopularMovies(@Query("page") final int page,
                                                        @Query("query") final String query);
}