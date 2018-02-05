package io.paulocosta.themoviedb.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.paulocosta.themoviedb.data.model.db.Movie;

/**
 * Created by paulocosta on 01/02/18.
 */

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<Movie> genres);

    @Query("SELECT * FROM MOVIES")
    List<Movie> getAllMovies();

}
