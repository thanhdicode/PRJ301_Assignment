/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author thanhhuynh
 */
public class Category {
     private int id;
    private String name;
    private Type type;

    public Category() {
    }

    public Category(int id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setTypeId(Type type) {
        this.type = type;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}


