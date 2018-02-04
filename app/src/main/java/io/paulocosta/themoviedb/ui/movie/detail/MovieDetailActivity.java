package io.paulocosta.themoviedb.ui.movie.detail;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import io.paulocosta.themoviedb.BR;
import io.paulocosta.themoviedb.R;
import io.paulocosta.themoviedb.databinding.ActivityMovieDetailBinding;
import io.paulocosta.themoviedb.ui.base.BaseActivity;

/**
 * Created by paulocosta on 03/02/18.
 */

public class MovieDetailActivity extends BaseActivity<ActivityMovieDetailBinding, MovieDetailViewModel> {

    @Inject
    MovieDetailViewModel viewModel;

    ActivityMovieDetailBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setMovie(getIntent().getParcelableExtra("movie"));
        binding = getViewDataBinding();
        setSupportActionBar(binding.detailToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public MovieDetailViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_movie_detail;
    }

}
