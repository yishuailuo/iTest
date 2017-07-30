package com.yishuailuo.iTest.controller;

import com.yishuailuo.iTest.dto.CityDto;
import com.yishuailuo.iTest.entity.City;
import com.yishuailuo.iTest.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by luoyishuai on 17/7/29.
 */
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/{name}")
    public City getCity(@PathVariable String name) {
        return cityService.get(name);
    }

    @GetMapping()
    public List<City> getAllCities() {
        return cityService.getAll();
    }

    @PostMapping()
    public City addCity(@Valid CityDto cityDto, BindingResult br) {
        if (br.hasErrors()) {
            return null;
        }
        return cityService.add(cityDto.toCity());
    }

    @PutMapping
    public City updateCity(@Valid CityDto cityDto, BindingResult br) {
        if (br.hasErrors()) {
            return null;
        }
        return cityService.update(cityDto.toCity());
    }

}
