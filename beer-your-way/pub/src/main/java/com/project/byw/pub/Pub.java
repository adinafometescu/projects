package com.project.byw.pub;

import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pub {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
