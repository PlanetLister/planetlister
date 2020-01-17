package com.codeup.adlister.dao;

import com.codeup.adlister.models.Planet;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLPlanetsDao implements Planets {
    private Connection connection = null;


    public MySQLPlanetsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to SQL database!", e);
        }
    }

    @Override
    public List<Planet> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM planetlister_db.planets");
            ResultSet rs = stmt.executeQuery();
            return createPlanetsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }



    @Override
    public Long insert(Planet planet) {
        try {
            String insertQuery = "INSERT INTO planetlister_db.planets (planetname, planetdesc, user_id) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(3, planet.getId());
            stmt.setString(1, planet.getName());
            stmt.setString(2, planet.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new planet.", e);
        }
    }

    private Planet extractPlanet(ResultSet rs) throws SQLException {
        return new Planet(
                rs.getString("planetname"),
                rs.getString("planetdesc"),
                rs.getInt("id"));
    }

    private List<Planet> createPlanetsFromResults(ResultSet rs) throws SQLException {
        List<Planet> planets = new ArrayList<>();
        while (rs.next()) {
            planets.add(extractPlanet(rs));
        }
        return planets;
    }

    public static void main(String[] args) {

        // testing all method
//        models.Ads adsDao = new dao.MySQLAdsDao();
//        List<models.Ad> ads = adsDao.all();
//        for (models.Ad ad : ads) {
//            System.out.println(ad);
//        }

        Config config = new Config();
        MySQLPlanetsDao TestDAO = new MySQLPlanetsDao(config);
        List<Planet> testListPlanets = TestDAO.all();

        for (Planet planet : testListPlanets) {
            System.out.println(planet);
        }
    }
}


