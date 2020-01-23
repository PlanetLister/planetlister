package com.codeup.adlister.dao;

import com.codeup.adlister.models.Planet;

import java.util.List;

public interface Planets {

    // get a list of all the ads
    List<Planet> all();
    // insert a new ad and return the new ad's id
    int insert(Planet planet);
    //find a planet by specific id
    Planet findPlanetById(int id);
    //list planets by user
    List<Planet> usersPlanets(int id);
    //update all planets
    int updatePlanet(Planet planet);
    //delete a planet
    int deletePlanet(int id);
    int changeOwnerPlanet(Planet planet);
    //search planets
    List<Planet> search(String userInput);
}
