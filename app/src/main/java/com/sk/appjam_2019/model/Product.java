package com.sk.appjam_2019.model;

public class Product {
    private String thumbnail_url;
    private String brand;
    private String name;
    private String price;

    public Product() {
    }

    public Product(String thumbnail_url, String brand, String name, String price) {
        this.thumbnail_url = thumbnail_url;
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
