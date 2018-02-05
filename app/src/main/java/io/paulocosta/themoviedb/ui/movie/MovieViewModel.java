package io.paulocosta.themoviedb.ui.movie;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;

import com.malinskiy.superrecyclerview.OnMoreListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.paulocosta.themoviedb.data.DataManager;
import io.paulocosta.themoviedb.data.model.api.ApiResponse;
import io.paulocosta.themoviedb.data.model.db.Movie;
import io.paulocosta.themoviedb.ui.base.BaseViewModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class MovieViewModel extends BaseViewModel<MovieNavigator> {

    private final ObservableArrayList<Movie> moviesObservableArrayList = new ObservableArrayList<>();

    private final MutableLiveData<List<Movie>> movieListLiveData;

    private final MutableLiveData<Integer> currentPage;

    private static final int SEARCH_DEBOUNCE_MILLIS = 300;

    public MovieViewModel(DataManager dataManager) {
        super(dataManager);
        movieListLiveData = new MutableLiveData<>();
        currentPage = new MutableLiveData<>();
        currentPage.setValue(1);
        fetchMoviesAndGenres();
    }

    public OnMoreListener getOnMoreLister() {
        return (overallItemsCount, itemsBeforeMore, maxLastVisiblePosition) -> {
            int page = currentPage.getValue();
            if (overallItemsCount > 0) {
                currentPage.setValue(page + 1);
                fetchMovies();
            }
        };
    }

    public void fetchMoviesAndGenres() {
        getCompositeDisposable().add(getDataManager()
                .fetchAndInsertGenres()
                .flatMap(b -> getDataManager().fetchAndInsertMovies(currentPage.getValue()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(handleMovies(), handleError())
        );
    }

    Consumer<List<Movie>> handleMovies() {
        return movies -> {
            setIsLoading(false);
            updateMovieLiveData(movies);
        };
    }

    Consumer<Throwable> handleError() {
        return throwable -> {
            setIsLoading(false);
            fetchLocalMovies();
        };
    }

    void fetchLocalMovies() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager().getDBMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> {
                    setIsLoading(false);
                    clearData();
                    currentPage.setValue(1);
                    this.movieListLiveData.setValue(movies);
                })
        );
    }

    public void fetchMovies() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager().fetchUpcomingMovies(currentPage.getValue())
                .map(ApiResponse::getResults)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(handleMovies(), handleError())
        );
    }

    void updateMovieLiveData(List<Movie> movies) {
        List<Movie> updated = new ArrayList<>();
        List<Movie> current = movieListLiveData.getValue();
        if (current != null) {
            updated.addAll(current);
        }
        updated.addAll(movies);
        movieListLiveData.setValue(updated);
    }

    private void searchMovies(String query) {
        setIsLoading(true);
        getDataManager().searchMovies(currentPage.getValue(), query)
                .map(ApiResponse::getResults)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(handleMovies(), handleError());
    }

    void clearData() {
        currentPage.setValue(1);
        movieListLiveData.setValue(new ArrayList<>());
    }

    void onSearchClose() {
        clearData();
        fetchMovies();
    }

    void onSearch(final Observable<String> searchObs) {
        searchObs
                .debounce(SEARCH_DEBOUNCE_MILLIS, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(search -> {
                    if (search.isEmpty()) {
                        clearData();
                        fetchMovies();
                    } else {
                        clearData();
                        searchMovies(search);
                    }
                });
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
