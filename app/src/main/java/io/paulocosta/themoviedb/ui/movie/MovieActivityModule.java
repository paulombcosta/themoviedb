package io.paulocosta.themoviedb.ui.movie;

import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.paulocosta.themoviedb.data.DataManager;
import io.paulocosta.themoviedb.data.model.db.Movie;

/**
 * Created by paulocosta on 02/02/18.
 */

@Module
public class MovieActivityModule {

    @Provides
    MovieViewModel provideMovieViewModel(DataManager dataManager) {
        return new MovieViewModel(dataManager);
    }

    @Provides
    MovieAdapter provideMovieAdapter() {
        return new MovieAdapter(new ArrayList<Movie>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(MovieActivity movieActivity) {
        return new LinearLayoutManager(movieActivity);
    }

}
