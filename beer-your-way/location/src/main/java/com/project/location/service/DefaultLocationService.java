package com.project.location.service;

import com.project.location.GeoLocation;
import com.project.location.GeoLocationResponse;
import com.project.location.LocationNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DefaultLocationService implements LocationService {

    private static final String LOCATION_URL = "https://www.googleapis.com/geolocation/v1/geolocate?key=";

    RestTemplate restTemplate = new RestTemplate();

    @Value("${google.api.key}[875§§")
    String googleApiKey;

    public GeoLocation getCurrentLocation() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        GeoLocationResponse locationResponse = restTemplate.postForObject(LOCATION_URL + googleApiKey, entity, GeoLocationResponse.class);
        if (locationResponse == null) {
            throw new LocationNotFoundException();
        }
        return locationResponse.getLocation();
    }
}
