package io.paulocosta.themoviedb.ui.main;

import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.paulocosta.themoviedb.data.DataManager;
import io.paulocosta.themoviedb.data.model.api.MovieResponse;

/**
 * Created by paulocosta on 02/02/18.
 */

@Module
public class MovieActivityModule {

    @Provides
    MovieViewModel provideMainViewModel(DataManager dataManager) {
        return new MovieViewModel(dataManager);
    }

    @Provides
    MovieAdapter provideMovieAdapter() {
        return new MovieAdapter(new ArrayList<MovieResponse>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(MovieActivity movieActivity) {
        return new LinearLayoutManager(movieActivity);
    }

}
