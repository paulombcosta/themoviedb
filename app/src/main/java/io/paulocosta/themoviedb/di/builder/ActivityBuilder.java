package io.paulocosta.themoviedb.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.paulocosta.themoviedb.ui.main.MovieActivity;
import io.paulocosta.themoviedb.ui.main.MovieActivityModule;

/**
 * Created by paulocosta on 01/02/18.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MovieActivityModule.class)
    abstract MovieActivity bindMovieActivity();

}
