package com.yishuailuo.iTest.service;

import com.yishuailuo.iTest.entity.City;

import java.util.List;

/**
 * Created by luoyishuai on 17/7/29.
 */

public interface CityService {

    City get(String name);

    List<City> getAll();

    City add(City city);

    City update(City city);

}
