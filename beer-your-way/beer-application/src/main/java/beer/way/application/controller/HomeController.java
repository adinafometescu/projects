package beer.way.application.controller;

import beer.way.product.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    BeerService beerService;

    @GetMapping("/")
    public String getHomePage(Map<String,Object> model) {
        model.put("beer",beerService.getBeerWithId("123").get());
        return "index";
    }

}
