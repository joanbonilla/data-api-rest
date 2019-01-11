package io.spring.api.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Organization {

  @JsonProperty("code")
  private String code;
  @JsonProperty("display_name")
  private String name;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
