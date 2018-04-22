package com.project.byw.pub.service;

import com.project.byw.pub.Pub;
import com.project.byw.pub.repository.PubRepository;
import com.project.location.GeoLocation;
import com.project.location.service.LocationService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultPubService implements PubService {

    @Autowired
    LocationService locationService;

    @Autowired
    PubRepository pubRepository;

    @Autowired
    private Client client;

    @Override
    public List<String> findPubsWithin(Integer distance) {
        GeoLocation geoLocation = locationService.getCurrentLocation();
        QueryBuilder qb = QueryBuilders.geoDistanceQuery("location")
                .point(geoLocation.getLat(), geoLocation.getLng())
                .distance(distance, DistanceUnit.KILOMETERS);

        SearchResponse searchResponse = client.prepareSearch("pub")
                .setTypes("geo-class-point-type")
                .setQuery(qb)
                .execute()
                .actionGet();
        return Arrays.stream(searchResponse.getHits()
                .getHits())
                .map(SearchHit::getId)
                .collect(Collectors.toList());
    }

    @EventListener(ContextRefreshedEvent.class)
    public void addTestPub() {
        Pub pub = new Pub();
        pub.setId("123");
        pub.setLocation(new GeoPoint(45.7592491, 21.2295633));
        pub.setName("Atelier Beeroteka");
        pubRepository.save(pub);

        Pub bier = new Pub();
        bier.setId("124");
        bier.setLocation(new GeoPoint(45.7587251, 21.2291707));
        bier.setName("Bier Republik");
        pubRepository.save(bier);
    }

}
