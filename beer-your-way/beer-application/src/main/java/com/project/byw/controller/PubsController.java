package com.project.byw.controller;

import com.project.byw.pub.service.CompanyService;
import beer.way.company.service.location.GeoLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class PubsController {

    @Value("google.api.key")
    String googleApiKey;

    @Autowired
    CompanyService companyService;

    @GetMapping("/pubs")
    public String getPubsPage(Map<String,Object> model) {
        model.put("apiKey",googleApiKey);
        return "pubs";
    }

    @GetMapping(value = "/location", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeoLocation getLocation(){
 v          return companyService.getCurrentLocation();
    }
}