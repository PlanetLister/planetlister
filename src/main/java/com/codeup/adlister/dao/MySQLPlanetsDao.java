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
    public int insert(Planet planet) {
        try {
            String insertQuery = "INSERT INTO planets (planetname, planetdesc, user_id) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(3, planet.getUser_id());
            stmt.setString(1, planet.getName());
            stmt.setString(2, planet.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new planet.", e);
        }
    }

    private Planet extractPlanet(ResultSet rs) throws SQLException {
        return new Planet(
                rs.getInt("id"),
                rs.getString("planetname"),
                rs.getString("planetdesc"),
                rs.getInt("user_id")
                );
    }

    private List<Planet> createPlanetsFromResults(ResultSet rs) throws SQLException {
        List<Planet> planets = new ArrayList<>();
        while (rs.next()) {
            planets.add(extractPlanet(rs));
        }
        return planets;
    }

 public Planet findPlanetById(int id){
     String findPlanetQuery = "SELECT * FROM planets WHERE id = ?";
     Planet result = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(findPlanetQuery);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                result = new Planet(rs.getInt("id"),
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
    public List<Planet> usersPlanets(int id) {
        String usersPlanetQuery = "SELECT planetname, planetdesc, planets.id, planets.user_id from users join planets on users.id = planets.user_id WHERE users.id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(usersPlanetQuery);
            stmt.setInt(1, id);
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

    public int deletePlanet(int id){
        String query = "DELETE FROM planets WHERE id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);
            int count = stmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting planet");
        }
    }

    public List<Planet> search(String userInput){
        String query = "SELECT * FROM planets WHERE planetname LIKE ? OR planetdesc LIKE ?";
        String queryWildCard = userInput + "%";

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, queryWildCard);
            stmt.setString(2, queryWildCard);

            ResultSet rs = stmt.executeQuery();

            return createPlanetsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error searching for planets");
        }
    }

    public static void main(String args[]){
        Config config = new Config();
        MySQLPlanetsDao factory = new MySQLPlanetsDao(config);
        Planet test = factory.findPlanetById(12);
        System.out.println(test);
    }

}




