package com.yishuailuo.iTest.mapper;

import com.yishuailuo.iTest.entity.City;
import org.apache.ibatis.annotations.Select;

/**
 * Created by luoyishuai on 17/7/29.
 */
public interface CityMapper {

    @Select("select * from city where name = #{name}")
    City get(String name);
}
