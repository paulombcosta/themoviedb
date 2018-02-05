package io.paulocosta.themoviedb.ui.movie.detail;

import dagger.Module;
import dagger.Provides;
import io.paulocosta.themoviedb.data.DataManager;


@Module
public class MovieDetailModule {

    @Provides
    MovieDetailViewModel provideViewModel(DataManager dataManager) {
        return new MovieDetailViewModel(dataManager);
    }

}
