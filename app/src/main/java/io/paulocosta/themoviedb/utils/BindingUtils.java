/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package io.paulocosta.themoviedb.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import io.paulocosta.themoviedb.data.model.db.Movie;
import io.paulocosta.themoviedb.data.remote.ImageUrlFormatter;
import io.paulocosta.themoviedb.ui.main.MovieAdapter;

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter"})
    public static void addMovieItems(RecyclerView recyclerView,
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
