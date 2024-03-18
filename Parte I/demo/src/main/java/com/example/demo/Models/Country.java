package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}