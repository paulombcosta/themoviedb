package io.paulocosta.themoviedb.data.local;


import java.util.List;

import io.paulocosta.themoviedb.data.model.db.Movie;
import io.reactivex.Single;


public interface DbHelper {

    Single<List<Movie>> getAllMovies();

}
