package com.project.byw.pub.controller;

import com.project.byw.pub.Pub;
import com.project.byw.pub.service.PubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PubController {

    @Autowired
    PubService pubService;

    @GetMapping("/search/pubs")
    List<Pub> getPubsWithinDistance(@RequestParam Integer distance) {
        return pubService.findPubsWithin(distance);
    }
}
