package io.paulocosta.themoviedb.data;

import javax.inject.Inject;

import io.paulocosta.themoviedb.data.local.DbHelper;
import io.paulocosta.themoviedb.data.model.api.UpcomingResponse;
import io.paulocosta.themoviedb.data.remote.ApiHelper;
import io.reactivex.Single;

public class AppDataManager implements DataManager {

    private final DbHelper dbHelper;
    private final ApiHelper apiHelper;


    @Inject
    public AppDataManager(DbHelper dbHelper, ApiHelper apiHelper) {
        this.dbHelper = dbHelper;
        this.apiHelper = apiHelper;
    }

    @Override
    public Single<UpcomingResponse> getUpcomingMovies() {
        return apiHelper.getUpcomingMovies();
    }
}
