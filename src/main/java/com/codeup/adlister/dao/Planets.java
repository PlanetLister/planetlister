package com.codeup.adlister.dao;

import com.codeup.adlister.models.Planet;

import java.util.List;

public interface Planets {
    //function to display all planets
    List<Planet> all();

    //function to inset a new planet into the database
    Long insert(Planet planet);
}
