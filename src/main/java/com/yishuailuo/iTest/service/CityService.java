package com.yishuailuo.iTest.service;

import com.yishuailuo.iTest.entity.City;

import java.util.List;

/**
 * Created by luoyishuai on 17/7/29.
 */

public interface CityService {

    City add(City city);

    City update(City city);

    void delete(Integer id);

    City getById(Integer id);

    City getByName(String name);

    List<City> getAll();
}
