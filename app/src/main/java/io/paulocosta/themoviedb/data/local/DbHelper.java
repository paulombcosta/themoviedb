package io.paulocosta.themoviedb.data.local;


import java.util.List;

import io.paulocosta.themoviedb.data.model.db.Genre;
import io.paulocosta.themoviedb.data.model.db.Movie;
import io.reactivex.Single;


public interface DbHelper {

    Single<List<Movie>> getDBMovies();

    Single<Boolean> insertGenres(List<Genre> genres);

    Single<Boolean> insertMovies(List<Movie> movies);


}
