package com.project.byw.pub.service;

import com.project.byw.pub.Pub;
import com.project.location.GeoLocation;

import java.util.List;

public interface PubService {

    /**
     * find all pubs located with the radius {@param numberKm}
     * the method will receive current location and will return all found pubs with the maximum distance
     *
     * @param distance - number of km
     * @return
     */
    List<Pub> findPubsWithin(Integer distance);

    List<Pub> findPubsWithin(GeoLocation location, Integer distance);
}
