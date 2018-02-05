package io.paulocosta.themoviedb.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.paulocosta.themoviedb.ui.movie.MovieActivity;
import io.paulocosta.themoviedb.ui.movie.MovieActivityModule;
import io.paulocosta.themoviedb.ui.movie.detail.MovieDetailActivity;
import io.paulocosta.themoviedb.ui.movie.detail.MovieDetailModule;


@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MovieActivityModule.class)
    abstract MovieActivity bindMovieActivity();

    @ContributesAndroidInjector(modules = MovieDetailModule.class)
    abstract MovieDetailActivity bindMovieDetailActivity();

}
