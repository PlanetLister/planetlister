package com.codeup.adlister.models;

import com.codeup.adlister.util.Password;

//Reusing the User model
public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private String filepath_to_avatar;

    public User() {}

    public User(String username, String email, String password, String avatar) {
        this.username = username;
        this.email = email;
        setPassword(password);
        this.filepath_to_avatar = avatar;
    }

    public User(long id, String username, String email, String password, String avatar) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.filepath_to_avatar = avatar;
    }

    public User(String username, String email){
        this.username = username;
        this.email = email;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = Password.hash(password);
    }

    public String getFilePath(){
        return this.filepath_to_avatar;
    }

    public void setFilepath(String avatar){
        this.filepath_to_avatar = avatar;
    }

    public String toString(){
        return "{Username: "+ this.username + ", Email: "+this.email+", Password: "+this.password+"} ";
    }
}
