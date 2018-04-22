package com.project.byw.controller;

import com.project.byw.pub.service.PubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class SearchController {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    PubService pubService;

    @GetMapping("/pubs")
    public String getPubsPage(Map<String,Object> model) {
        return "pubs";
    }

}