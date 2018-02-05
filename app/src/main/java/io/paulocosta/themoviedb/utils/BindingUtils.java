package io.paulocosta.themoviedb.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;

import io.paulocosta.themoviedb.data.model.db.Movie;
import io.paulocosta.themoviedb.data.remote.ImageUrlFormatter;
import io.paulocosta.themoviedb.ui.movie.MovieAdapter;

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter"})
    public static void addMovieItems(SuperRecyclerView recyclerView,
                                  ArrayList<Movie> movies) {
        MovieAdapter adapter = (MovieAdapter) recyclerView.getAdapter();
        if(adapter != null) {
            adapter.clearItems();
            adapter.addItems(movies);
        }
    }

    @BindingAdapter({"imageUrlSm"})
    public static void setImageUrlSm(ImageView imageView, String path) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(ImageUrlFormatter.getSmallImagePath(path))
                .into(imageView);
    }

    @BindingAdapter({"imageUrlLg"})
    public static void setImageUrlLg(ImageView imageView, String path) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(ImageUrlFormatter.getLargeImagePath(path))
                .into(imageView);
    }

}
