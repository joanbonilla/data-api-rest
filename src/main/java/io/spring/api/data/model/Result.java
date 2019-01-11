package io.spring.api.data.model;

import java.util.List;

public class Result {

  private List<ItemResponse> results;

  public List<ItemResponse> getResults() {
    return results;
  }

  public void setResults(List<ItemResponse> results) {
    this.results = results;
  }
}
