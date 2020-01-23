package com.codeup.adlister.models;
//adding a Category model

public class Category {
    private int id;
    private String name;

    public Category(){}

    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Category(String name){
        this.name = name;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        return "{"+this.id+ " "+this.name+"}";
    }
}
