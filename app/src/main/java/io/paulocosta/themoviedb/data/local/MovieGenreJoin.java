package io.paulocosta.themoviedb.data.local;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import io.paulocosta.themoviedb.data.model.db.Genre;
import io.paulocosta.themoviedb.data.model.db.Movie;

/**
 * Created by paulocosta on 04/02/18.
 */

@Entity(tableName = "movie_genre_join",
        primaryKeys = {"movieId", "genreId"},
        foreignKeys = {
                @ForeignKey(entity = Movie.class,
                        parentColumns = "id",
                        childColumns = "genreId"),
                @ForeignKey(entity = Genre.class,
                        parentColumns = "id",
                        childColumns = "movieId")
        })
public class MovieGenreJoin {

        public final int movieId;
        public final int genreId;

        public MovieGenreJoin(final int movieId, final int genreId) {
                this.movieId = movieId;
                this.genreId = genreId;
        }


}
