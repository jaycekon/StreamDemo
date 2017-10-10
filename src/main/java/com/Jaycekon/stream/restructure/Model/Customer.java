package com.Jaycekon.stream.restructure.Model;

/**
 * Created by Jaycekon on 2017/9/24.
 */
public class Customer {
    private int id;
    private String name;

    public Customer(int id) {
        this.id = id;
        this.name = "Jaycekon";
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
