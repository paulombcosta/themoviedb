package io.paulocosta.themoviedb.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;

import java.util.ArrayList;
import java.util.List;

import io.paulocosta.themoviedb.data.DataManager;
import io.paulocosta.themoviedb.data.model.api.MovieResponse;
import io.paulocosta.themoviedb.ui.base.BaseViewModel;

/**
 * Created by paulocosta on 02/02/18.
 */

public class MovieViewModel extends BaseViewModel {

    private final ObservableArrayList<MovieResponse> moviesObservableArrayList = new ObservableArrayList<>();

    private final MutableLiveData<List<MovieResponse>> movieListLiveData;

    public MovieViewModel(DataManager dataManager) {
        super(dataManager);
        movieListLiveData = new MutableLiveData<>();
        fetchMovies();
    }

    public void fetchMovies() {
        movieListLiveData.setValue(fakeData());
    }

    public List<MovieResponse> fakeData() {
        List<MovieResponse> movies = new ArrayList<>();
        MovieResponse fake1 = new MovieResponse();
        fake1.setOriginalTitle("Fake movie 1");
        MovieResponse fake2 = new MovieResponse();
        fake2.setOriginalTitle("Fake movie 2");

        movies.add(fake1);
        movies.add(fake2);

        return movies;
    }

    public MutableLiveData<List<MovieResponse>> getMovieListLiveData() {
        return movieListLiveData;
    }

    public void addMovieItemToList(List<MovieResponse> movies) {
        moviesObservableArrayList.clear();
        moviesObservableArrayList.addAll(movies);
    }

    public ObservableArrayList<MovieResponse> getMoviesObservableArrayList() {
        return moviesObservableArrayList;
    }



}
