package com.restuarant.satwik.Model;

public class Bestsellermodel {

    String name,subtitle;
    int image_src;

    public Bestsellermodel(String name, String subtitle, int image_src) {
        this.name = name;
        this.subtitle = subtitle;
        this.image_src = image_src;
    }

    public Bestsellermodel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getImage_src() {
        return image_src;
    }

    public void setImage_src(int image_src) {
        this.image_src = image_src;
    }
}
