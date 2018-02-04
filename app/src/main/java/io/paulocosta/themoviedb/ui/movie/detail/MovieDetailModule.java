package io.paulocosta.themoviedb.ui.movie.detail;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import dagger.Module;
import dagger.Provides;
import io.paulocosta.themoviedb.data.DataManager;
import io.paulocosta.themoviedb.data.model.db.Movie;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by paulocosta on 04/02/18.
 */

@Module
public class MovieDetailModule {

//    @Qualifier
//    @Documented
//    @Retention(RUNTIME)
//    @interface MovieExtra {}
//
//    @MovieExtra
//    Movie getMovie() {
//        return getIn
//    }


    @Provides
    MovieDetailViewModel provideViewModel(DataManager dataManager) {
        return new MovieDetailViewModel(dataManager);
    }

}
