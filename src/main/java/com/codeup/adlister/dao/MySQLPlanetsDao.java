package com.codeup.adlister.dao;

import com.codeup.adlister.models.Config;
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
            stmt = connection.prepareStatement("SELECT * FROM planets");
            ResultSet rs = stmt.executeQuery();
            return createPlanetsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }



    @Override
    public Long insert(Planet planet) {
        try {
            String insertQuery = "INSERT INTO planets (planetname, planetdesc, user_id) VALUES (?, ?, ?)";
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

 public Planet findPlanetById(long id){
     String findPlanetQuery = "SELECT * FROM planets WHERE id = ?";
     Planet result = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(findPlanetQuery);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                result = new Planet((int) id,
                        rs.getString("planetname"),
                        rs.getString("planetdesc"),
                        rs.getInt("user_id"));
            }
        } catch (SQLException e){
            throw new RuntimeException("Error finding Planet by that ID.", e);
        }
        return result;
 };

    @Override
    public List<Planet> usersPlanets(long id) {
        String usersPlanetQuery = "SELECT planetname, planetdesc, planets.id from users join planets on users.id = planets.user_id WHERE users.id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(usersPlanetQuery);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            return createPlanetsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving users planets.", e);
        }
    }

    public int updatePlanet(Planet planet){
        String query = "UPDATE planets SET planetname = ?, planetdesc = ? WHERE id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, planet.getName());
            stmt.setString(2, planet.getDescription());
            stmt.setLong(3, planet.getId());
            int count = stmt.executeUpdate();
            return count;
        }catch (SQLException e){
            throw new RuntimeException("Error updating planet");
        }
    }

    public int deletePlanet(long id){
        String query = "DELETE FROM planets WHERE id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, id);
            int count = stmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting planet");
        }
    }

//    public static void main(String args[]){
//            Config config = new Config();
//            List<Planet> planets = new MySQLPlanetsDao(config).all();
//            System.out.println(planets);
////            Planet test = new Planet(10, "Deimos Test", "New Deimos Description",  1);
////            int anotherTest = new MySQLPlanetsDao(config).updatePlanet(test);
////            System.out.println(anotherTest);
////            planets = new MySQLPlanetsDao(config).all();
////            System.out.println(planets);
//            int test = new MySQLPlanetsDao(config).deletePlanet(10);
//        System.out.println(test);
//        System.out.println(planets);
//
//    }
}


