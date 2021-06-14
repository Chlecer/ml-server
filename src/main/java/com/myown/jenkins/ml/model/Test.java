package com.myown.jenkins.ml.model;

public class Test {

    public String name;
    public String description;

    // Nothing fancy. One important thing to note is that having a default constructor is required by the
    // JSON serialization layer.
    public Test(){}

    public Test(String name, String description) {
        this.name = name;
        this.description = description;
    }


}
