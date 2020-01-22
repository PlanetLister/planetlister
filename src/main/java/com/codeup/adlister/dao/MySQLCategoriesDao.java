package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.Config;
import com.codeup.adlister.models.Planet;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories {
    private Connection connection = null;

    public MySQLCategoriesDao(Config config){
        try{
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

    //function to display all categories related to the planets
    public List<Category> all(){
        PreparedStatement stmt = null;
        try{
            stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        }catch (SQLException e){
            throw new RuntimeException("Error retrieving all categories.", e);
        }
    }

    private List<Category> createCategoriesFromResults(ResultSet rs) throws SQLException{
        List<Category> all = new ArrayList<>();
        while(rs.next()){
            all.add(extractCategory(rs));
        }

        return all;
    }

    private Category extractCategory(ResultSet rs) throws SQLException{
        return new Category(
                rs.getInt("id"),
                rs.getString("name")
        );
    }

    //function to add a category
    public Long insert(Category category){
        try{
            String query = "INSERT INTO categories (name) VALUES (?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, category.getName());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();

            return rs.getLong(1);
        }catch (SQLException e){
            throw new RuntimeException("Error inserting category.", e);
        }
    }

    //function to display planets with respective categories
    public List<Category> combined(Planet planet){
        String query = "SELECT categories.id, categories.name FROM categories JOIN ad_category ON categories.id = ad_category.category_id JOIN planets ON planets.id = ad_category.planet_id WHERE planets.id = ?;";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, planet.getId());
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        }catch (SQLException e){
            throw new RuntimeException("Error inserting category.", e);
        }
    }
}