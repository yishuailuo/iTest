package com.yishuailuo.iTest.service;

import com.yishuailuo.iTest.entity.City;
import com.yishuailuo.iTest.exception.EntityNotFoundException;
import com.yishuailuo.iTest.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by luoyishuai on 17/7/30.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public City add(City city) {
        cityMapper.add(city);
        return cityMapper.getById(city.getId());
    }

    @Override
    public City update(City city) {
        City cityFromDb = cityMapper.getById(city.getId());
        if (null == cityFromDb) {
            throw new EntityNotFoundException("NoCity");
        }
        cityMapper.update(city);
        return cityMapper.getById(city.getId());
    }

    @Override
    public void delete(Integer id){
        cityMapper.deleteById(id);
    }

    @Override
    public City getById(Integer id) {
        City city = cityMapper.getById(id);
        if (null == city) {
            throw new EntityNotFoundException("NoCity");
        }
        return city;
    }

    @Override
    public City getByName(String name) {
        City city = cityMapper.getByName(name);
        if (null == city) {
            throw new EntityNotFoundException("NoCity");
        }
        return city;
    }

    @Override
    public List<City> getAll() {

        List<City> cities = cityMapper.getAll();
        if (CollectionUtils.isEmpty(cities)) {
            throw new EntityNotFoundException("NoCity");
        }
        return cities;
    }

}
