package io.paulocosta.themoviedb.data.model.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import io.paulocosta.themoviedb.data.model.db.Movie;

public class ApiResponse implements Serializable {

   private Integer page;

   @SerializedName("total_pages")
   private Integer totalPages;

   private List<Movie> results;

   public Integer getPage() {
      return page;
   }

   public void setPage(Integer page) {
      this.page = page;
   }

   public List<Movie> getResults() {
      return results;
   }

   public void setResults(List<Movie> results) {
      this.results = results;
   }

}
