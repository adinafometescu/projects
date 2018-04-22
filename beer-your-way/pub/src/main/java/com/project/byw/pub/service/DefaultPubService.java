package com.project.byw.pub.service;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultPubService implements PubService {

    @Autowired
    LocationService locationService;

    @Autowired
    PubRepository pubRepository;

    @Autowired
    private Client client;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Logger logger = LoggerFactory.getLogger(DefaultPubService.class);

    @Override
    public List<Pub> findPubsWithin(Integer distance) {
        GeoLocation geoLocation = locationService.getCurrentLocation();
        QueryBuilder qb = QueryBuilders.geoDistanceQuery("location")
                .point(geoLocation.getLat(), geoLocation.getLng())
                .distance(distance, DistanceUnit.KILOMETERS);

        SearchResponse searchResponse = client.prepareSearch("pub")
                .setTypes("geo-class-point-type")
                .setQuery(qb)
                .execute()
                .actionGet();
        List<Pub> list = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            Pub pub;
            try {
                pub = objectMapper.readValue(hit.getSourceAsString(), Pub.class);
            } catch (IOException e) {
                logger.error("Cannot read pub from result ", e);
                continue;
            }
            list.add(pub);
        }
        return list;
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
