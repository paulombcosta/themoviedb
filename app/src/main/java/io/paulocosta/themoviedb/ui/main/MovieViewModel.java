package io.paulocosta.themoviedb.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;

import java.util.ArrayList;
import java.util.List;

import io.paulocosta.themoviedb.data.DataManager;
import io.paulocosta.themoviedb.data.model.db.Movie;
import io.paulocosta.themoviedb.ui.base.BaseViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by paulocosta on 02/02/18.
 */

public class MovieViewModel extends BaseViewModel {

    private final ObservableArrayList<Movie> moviesObservableArrayList = new ObservableArrayList<>();

    private final MutableLiveData<List<Movie>> movieListLiveData;

    private final MutableLiveData<Integer> currentPage;

    public MovieViewModel(DataManager dataManager) {
        super(dataManager);
        movieListLiveData = new MutableLiveData<>();
        currentPage = new MutableLiveData<>();
        currentPage.setValue(1);
        fetchMovies();
    }

    public void fetchMovies() {
        //movieListLiveData.setValue(fakeData());
        test();
    }

    public void test() {
        getDataManager().getUpcomingMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            if (response != null) {
                                movieListLiveData.setValue(response.getResults());
                            }
                        },
                        e -> {
                        });
    }

    public List<Movie> fakeData() {
        List<Movie> movies = new ArrayList<>();
        Movie fake1 = new Movie();
        fake1.setOriginalTitle("Fake movie 1");
        Movie fake2 = new Movie();
        fake2.setOriginalTitle("Fake movie 2");

        movies.add(fake1);
        movies.add(fake2);

        return movies;
    }

    public MutableLiveData<List<Movie>> getMovieListLiveData() {
        return movieListLiveData;
    }

    public void addMovieItemToList(List<Movie> movies) {
        moviesObservableArrayList.clear();
        moviesObservableArrayList.addAll(movies);
    }

    public ObservableArrayList<Movie> getMoviesObservableArrayList() {
        return moviesObservableArrayList;
    }



}
