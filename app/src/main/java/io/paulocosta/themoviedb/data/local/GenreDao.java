package io.paulocosta.themoviedb.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import java.util.List;

import io.paulocosta.themoviedb.data.model.db.Genre;


@Dao
public interface GenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Genre> genres);

}
