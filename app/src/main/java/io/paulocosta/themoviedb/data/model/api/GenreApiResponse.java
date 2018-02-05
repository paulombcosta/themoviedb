package io.paulocosta.themoviedb.data.model.api;

import java.util.List;

import io.paulocosta.themoviedb.data.model.db.Genre;

/**
 * Created by paulocosta on 04/02/18.
 */

public class GenreApiResponse {

    private List<Genre> genres;

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

}
