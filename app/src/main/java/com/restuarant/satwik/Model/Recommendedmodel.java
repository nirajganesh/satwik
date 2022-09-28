package com.restuarant.satwik.Model;

public class Recommendedmodel {
    String title,subtitle,offers,price;
    int image_src;

    public Recommendedmodel(String title, String subtitle, String offers, String price, int image_src) {
        this.title = title;
        this.subtitle = subtitle;
        this.offers = offers;
        this.price = price;
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

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage_src() {
        return image_src;
    }

    public void setImage_src(int image_src) {
        this.image_src = image_src;
    }
}
