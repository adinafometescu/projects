package com.project.byw.pub.controller;

import com.project.byw.pub.Pub;
import com.project.byw.pub.service.PubService;
import com.project.location.GeoLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PubController {

    @Autowired
    PubService pubService;

    @GetMapping("/search/pubs")
    public List<Pub> getPubsWithinDistance(@RequestParam Integer distance, GeoLocation location) {
        // return pubService.findPubsWithin(location,distance);
        //mock data for the moment
        Pub pub = new Pub();
        pub.setId("123");
        pub.setName("Beer your way");
        pub.setLocation(new GeoPoint(45.744028, 21.232215));
        return Arrays.asList(pub);
    }
}
