package io.paulocosta.themoviedb.ui.movie;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import io.paulocosta.themoviedb.BR;
import io.paulocosta.themoviedb.R;
import io.paulocosta.themoviedb.databinding.ActivityMovieBinding;
import io.paulocosta.themoviedb.ui.base.BaseActivity;
import io.paulocosta.themoviedb.utils.RxSearchObservable;
import io.reactivex.Observable;

public class MovieActivity extends BaseActivity<ActivityMovieBinding, MovieViewModel> {

    @Inject
    MovieViewModel viewModel;

    @Inject
    LinearLayoutManager layoutManager;

    @Inject
    MovieAdapter movieAdapter;

    ActivityMovieBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewDataBinding();
        setUp();
        subscribeToLiveData();
        setSupportActionBar(binding.toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movies_menu, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();

        Observable<String> searchObservable = RxSearchObservable.fromView(searchView);
        viewModel.onSearch(searchObservable);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.fetchMovies();
    }

    private void setUp() {
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.movieRecyclerView.setLayoutManager(layoutManager);
        binding.movieRecyclerView.setAdapter(movieAdapter);
        binding.movieRecyclerView.setupMoreListener(viewModel.getOnMoreLister(), 5);
    }

    private void subscribeToLiveData() {
        viewModel.getMovieListLiveData().observe(this,
                movies -> viewModel.addMovieItemToList(movies));
    }

    @Override
    public MovieViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_movie;
    }
}
