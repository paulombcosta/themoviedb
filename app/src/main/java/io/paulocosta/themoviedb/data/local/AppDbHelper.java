package io.paulocosta.themoviedb.data.local;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.paulocosta.themoviedb.data.model.db.Movie;
import io.reactivex.Single;

@Singleton
public class AppDbHelper implements DbHelper {

    private final AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public Single<List<Movie>> getAllMovies() {
        return null;
    }

}
