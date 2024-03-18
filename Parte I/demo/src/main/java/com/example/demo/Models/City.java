package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String country;
    @JsonProperty
    private String name;

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }
}
