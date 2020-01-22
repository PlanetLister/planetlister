package com.codeup.adlister.dao;

import com.codeup.adlister.models.Planet;

import java.util.List;

public interface Planets {

    // get a list of all the ads
    List<Planet> all();
    // insert a new ad and return the new ad's id
    int insert(Planet planet);
    Planet findPlanetById(int id);
    List<Planet> usersPlanets(int id);
    int updatePlanet(Planet planet);
    int deletePlanet(int id);
}
