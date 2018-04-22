package com.project.byw.pub.service;

import com.project.byw.pub.Pub;

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
}
