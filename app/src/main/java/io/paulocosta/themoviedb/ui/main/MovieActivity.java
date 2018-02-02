package io.paulocosta.themoviedb.ui.main;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import javax.inject.Inject;

import io.paulocosta.themoviedb.BR;
import io.paulocosta.themoviedb.R;
import io.paulocosta.themoviedb.data.model.api.MovieResponse;
import io.paulocosta.themoviedb.databinding.ActivityMovieBinding;
import io.paulocosta.themoviedb.ui.base.BaseActivity;

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.fetchMovies();
    }

    private void setUp() {
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.movieRecyclerView.setLayoutManager(layoutManager);
        binding.movieRecyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.movieRecyclerView.setAdapter(movieAdapter);
    }

    private void subscribeToLiveData() {
        viewModel.getMovieListLiveData().observe(this, new Observer<List<MovieResponse>>() {
            @Override
            public void onChanged(@Nullable List<MovieResponse> movieResponses) {
                viewModel.addMovieItemToList(movieResponses);
            }
        });
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
