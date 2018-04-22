package com.project.byw.pub.repository;

import com.project.byw.pub.Pub;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PubRepository extends ElasticsearchRepository<Pub, String> {
}
