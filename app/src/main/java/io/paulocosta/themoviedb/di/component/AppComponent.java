package io.paulocosta.themoviedb.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import io.paulocosta.themoviedb.MovieDBApp;
import io.paulocosta.themoviedb.di.builder.ActivityBuilder;
import io.paulocosta.themoviedb.di.module.AppModule;


@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class,ActivityBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    void inject(MovieDBApp app);

}
