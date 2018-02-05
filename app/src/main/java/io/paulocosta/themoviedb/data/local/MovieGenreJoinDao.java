package io.paulocosta.themoviedb.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.paulocosta.themoviedb.data.model.db.Genre;

/**
 * Created by paulocosta on 04/02/18.
 */

@Dao
public interface MovieGenreJoinDao {

    @Insert
    void insert(MovieGenreJoin movieGenreJoin);

    @Query("SELECT * FROM GENRES INNER JOIN movie_genre_join ON genres.id=movie_genre_join.genreId WHERE movie_genre_join.movieId=:movieId")
    List<Genre> getMovieGenres(final long movieId);

}
