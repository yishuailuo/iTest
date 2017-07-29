package com.yishuailuo.iTest.controller;

import com.yishuailuo.iTest.entity.City;
import com.yishuailuo.iTest.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luoyishuai on 17/7/29.
 */
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities/{name}")
    public City city(@PathVariable String name) {
        return cityService.get(name);
    }

}
