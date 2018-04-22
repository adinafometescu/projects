package com.project.byw.pub.service;

import com.project.byw.pub.Pub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultPubService implements PubService {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    LocationService locationService;

    public List<Pub> findByLocation() {
        CriteriaQuery geoLocationCriteriaQuery = new CriteriaQuery(
                new Criteria("location").within(new GeoPoint(45.7806d, 3.0875d), "20km"));
        return elasticsearchTemplate.queryForList(geoLocationCriteriaQuery, Pub.class);
    }


}
