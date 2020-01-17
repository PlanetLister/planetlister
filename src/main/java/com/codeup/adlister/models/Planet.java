package com.codeup.adlister.models;

//creating a new Planet model to replace the ads model
public class Planet {
    private int id;
    private String name;
    private String description;
    private int user_id;
    private String filepath_to_image;

    public Planet(){}

    public Planet(int id, String name, String description, int user_id, String filepath_to_image){
        this.id = id;
        this.name = name;
        this.description = description;
        this.user_id = user_id;
        this.filepath_to_image = filepath_to_image;
    }

    public Planet(String name, String description, int user_id, String filepath_to_image){
        this.name = name;
        this.description = description;
        this.user_id = user_id;
        this.filepath_to_image = filepath_to_image;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getUser_id(){
        return this.user_id;
    }

    public void setUser_id(int user_id){
        this.user_id = user_id;
    }

    public String getFilepath_to_image(){
        return this.filepath_to_image;
    }

    public void setFilepath_to_image(String filepath_to_image){
        this.filepath_to_image = filepath_to_image;
    }

    public String toString(){
        return "";
    }

}
