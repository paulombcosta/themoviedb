package io.paulocosta.themoviedb.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.paulocosta.themoviedb.data.AppDataManager;
import io.paulocosta.themoviedb.data.DataManager;
import io.paulocosta.themoviedb.data.local.AppDatabase;
import io.paulocosta.themoviedb.data.local.AppDbHelper;
import io.paulocosta.themoviedb.data.local.DbHelper;
import io.paulocosta.themoviedb.data.remote.ApiHelper;
import io.paulocosta.themoviedb.data.remote.AppApiHelper;
import io.paulocosta.themoviedb.data.remote.AuthInterceptor;
import io.paulocosta.themoviedb.data.remote.Endpoint;
import io.paulocosta.themoviedb.data.remote.UpcomingService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) { return application; }

    @Provides
    public OkHttpClient provideHTTPClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new AuthInterceptor())
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(final OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(Endpoint.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    UpcomingService provideMoviesService(final Retrofit retrofit) {
        return retrofit.create(UpcomingService.class);
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "moviesdb")
                .fallbackToDestructiveMigration()
                .build();
    }


}
