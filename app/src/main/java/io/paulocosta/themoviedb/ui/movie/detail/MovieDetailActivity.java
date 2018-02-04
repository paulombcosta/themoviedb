package io.paulocosta.themoviedb.ui.movie.detail;

import io.paulocosta.themoviedb.BR;
import io.paulocosta.themoviedb.R;
import io.paulocosta.themoviedb.databinding.ActivityMovieDetailBinding;
import io.paulocosta.themoviedb.ui.base.BaseActivity;

/**
 * Created by paulocosta on 03/02/18.
 */

public class MovieDetailActivity extends BaseActivity<ActivityMovieDetailBinding, MovieDetailViewModel> {

    @Override
    public MovieDetailViewModel getViewModel() {
        return null;
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
