package com.codeup.adlister.dao;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.Planet;

import java.util.List;

public interface Categories {
    //function to display all categories related to the planets
    List<Category> all();

    //function to add a category
    Long insert(int id, int planetId);

    //function to display planets with respective categories
    List<Category> combined(Planet planet);

    int deleteCategoriesPerPlanet(int id);
}
