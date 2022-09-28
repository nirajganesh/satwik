package com.restuarant.satwik.Model;

public class Cartmodel {
    String title,subtitle,price,quantity;
    int image_src;

    public Cartmodel(String title, String subtitle, String price, String quantity, int image_src) {
        this.title = title;
        this.subtitle = subtitle;
        this.price = price;
        this.quantity = quantity;
        this.image_src = image_src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getImage_src() {
        return image_src;
    }

    public void setImage_src(int image_src) {
        this.image_src = image_src;
    }
}
