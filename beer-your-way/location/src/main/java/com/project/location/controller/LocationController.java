package com.project.location.controller;

import com.project.location.GeoLocation;
import com.project.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping("/location")
    public GeoLocation getLocation() {
        return locationService.getCurrentLocation();
    }
}
