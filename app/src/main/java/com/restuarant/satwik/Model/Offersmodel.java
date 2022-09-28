package com.restuarant.satwik.Model;

public class Offersmodel {
    String  title,offers;

    public Offersmodel(String title, String offers) {
        this.title = title;
        this.offers = offers;
    }

    public Offersmodel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }
}
