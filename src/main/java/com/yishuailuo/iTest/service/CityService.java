package com.yishuailuo.iTest.service;

import com.yishuailuo.iTest.entity.City;
import com.yishuailuo.iTest.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by luoyishuai on 17/7/29.
 */
@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    public City get(String name) {
        return cityMapper.get(name);
    }
}
