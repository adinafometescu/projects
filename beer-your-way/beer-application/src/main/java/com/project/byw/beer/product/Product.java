package com.project.byw.beer.product;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Map;

public class Product {

    @Id
    private String id;

    private String brand;

    private Map<Locale, String> title;

    private Map<Locale,String> shortDescription;

    private Map<Locale,String> description;

    private BigDecimal price;

    private int stock;

    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Locale, String> getTitle() {
        return title;
    }

    public void setTitle(Map<Locale, String> title) {
        this.title = title;
    }

    public Map<Locale, String> getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(Map<Locale, String> shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Map<Locale, String> getDescription() {
        return description;
    }

    public void setDescription(Map<Locale, String> description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
