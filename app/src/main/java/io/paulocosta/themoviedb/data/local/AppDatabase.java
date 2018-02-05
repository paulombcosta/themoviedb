package io.paulocosta.themoviedb.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import io.paulocosta.themoviedb.data.model.db.Genre;
import io.paulocosta.themoviedb.data.model.db.Movie;


@Database(entities = {Movie.class, Genre.class, MovieGenreJoin.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MovieDao getMovieDao();

    public abstract GenreDao getGenreDao();

    public abstract MovieGenreJoinDao getMovieGenreJoinDao();

}
