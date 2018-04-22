package com.project.byw.pub;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import org.springframework.data.annotation.Id;

@Document(indexName = "pub", type = "geo-class-point-type")
public class Pub{

    @Id
    private String id;

    private String name;

    private GeoPoint location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }
}
