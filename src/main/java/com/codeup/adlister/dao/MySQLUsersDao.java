package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import com.codeup.adlister.models.Config;
import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }

    }

    @Override
    public User findByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }

    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    @Override
    public User findUserById(long id){
        String findUserQuery = "SELECT * FROM users WHERE id = ?";
        User result = null;
        try{
            PreparedStatement stmt = connection.prepareStatement(findUserQuery);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                result = new User(rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("filepath_to_avatar"));
            }
        }
        catch (SQLException e){
            throw new RuntimeException("Error finding USER by that ID.", e);
        }

        return result;
    };

    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password"),
                rs.getString("filepath_to_avatar")
        );

    }

    public User findPlanetsOwnerById(long id){
        String PlanetsOwnerQuery = "SELECT users.username, users.email from     planets join users on planets.user_id = users.id WHERE planets.id = ?";
        User result = null;
        try{
            PreparedStatement stmt = connection.prepareStatement(PlanetsOwnerQuery);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                result = new User(
                        rs.getString("username"),
                        rs.getString("email"));

            }
        }catch (SQLException e){
            throw new RuntimeException("Error finding User creator by ID.", e);
        }
        return result;
    }

    public int updateUser(User user){
        String query = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, (int) user.getId());
            int count = stmt.executeUpdate();
            return count;
        } catch (SQLException e){
            throw new RuntimeException("Error updating user");
        }
    }

//    public static void main(String args[]){
//        Config config = new Config();
//        Users test = new MySQLUsersDao(config);
//        //test.insert(new User("username2", "user@email.com", "P@ssw0rd", "avater"));
//        User mia = test.findByUsername("username2");
//        System.out.println(mia);
//        System.out.println(Password.check("P@ssw0rd",mia.getPassword()));
//    }

}

