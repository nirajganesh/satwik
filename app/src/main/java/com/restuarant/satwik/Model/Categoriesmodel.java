package com.restuarant.satwik.Model;

public class Categoriesmodel {
    String name;
    int image_src;

    public Categoriesmodel(String name, int image_src) {
        this.name = name;
        this.image_src = image_src;
    }

    public Categoriesmodel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage_src() {
        return image_src;
    }

    public void setImage_src(int image_src) {
        this.image_src = image_src;
    }
}
