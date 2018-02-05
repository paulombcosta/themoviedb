package io.paulocosta.themoviedb.data;


import java.util.List;

import io.paulocosta.themoviedb.data.local.DbHelper;
import io.paulocosta.themoviedb.data.model.db.Movie;
import io.paulocosta.themoviedb.data.remote.ApiHelper;
import io.reactivex.Single;

public interface DataManager extends ApiHelper, DbHelper {

    Single<Boolean> fetchAndInsertGenres();

    Single<List<Movie>> fetchAndInsertMovies(int page);
}
