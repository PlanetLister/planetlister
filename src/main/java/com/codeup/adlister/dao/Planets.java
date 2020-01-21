package com.codeup.adlister.dao;

import com.codeup.adlister.models.Planet;

import java.util.List;

public interface Planets {

    // get a list of all the ads
    List<Planet> all();
    // insert a new ad and return the new ad's id
    Long insert(Planet planet);
    Planet findPlanetById(long id);

}
