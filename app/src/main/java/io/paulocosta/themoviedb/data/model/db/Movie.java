package io.paulocosta.themoviedb.data.model.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;

/**
 * Created by paulocosta on 01/02/18.
 */

@Entity(tableName = "movies")
public class Movie {

    @Expose
    @PrimaryKey
    public long id;

    public String name;

}
