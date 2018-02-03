package io.paulocosta.themoviedb.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import io.paulocosta.themoviedb.data.model.db.Movie;
import io.paulocosta.themoviedb.databinding.ItemMovieViewBinding;
import io.paulocosta.themoviedb.ui.base.BaseViewHolder;

public class MovieAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Movie> movieList;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMovieViewBinding binding = ItemMovieViewBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false);
        return new MoviesViewHolder(binding);
    }

    public void clearItems() {
        movieList.clear();
    }

    public void addItems(List<Movie> movieList) {
        this.movieList.addAll(movieList);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MoviesViewHolder extends BaseViewHolder {

        private ItemMovieViewBinding binding;

        private MovieItemViewModel movieItemViewModel;

        public MoviesViewHolder(ItemMovieViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {

            final Movie movie = movieList.get(position);

            movieItemViewModel = new MovieItemViewModel(movie);

            binding.setViewModel(movieItemViewModel);

            binding.executePendingBindings();

        }

    }

}
