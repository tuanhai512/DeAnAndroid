package com.example.doanltdd.controller;

public class Contact {
    String Title;
    int Image;

    public Contact()
    {

    }
    public Contact(String Title) {
        this.Title = Title;
    }

    public Contact(String Title, int Image)
    {
        this.Title = Title;
        this.Image = Image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int Image) {
        this.Image = Image;
    }


}
