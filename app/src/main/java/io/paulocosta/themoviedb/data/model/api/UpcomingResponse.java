package io.paulocosta.themoviedb.data.model.api;

import java.io.Serializable;
import java.util.List;

import io.paulocosta.themoviedb.data.model.db.Movie;

public class UpcomingResponse implements Serializable {

   private Integer page;

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
