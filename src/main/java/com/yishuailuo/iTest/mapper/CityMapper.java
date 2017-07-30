package com.yishuailuo.iTest.mapper;

import com.yishuailuo.iTest.entity.City;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by luoyishuai on 17/7/29.
 */
public interface CityMapper {

    @Insert("insert into city (name, `desc`) values (#{name}, #{desc})")
    Integer add(City city);

    @Update("update city set name = #{name}, `desc`=#{desc} where id = #{id}")
    Integer update(City city);

    @Delete("delete from city where id = #{id}")
    Integer deleteById(Integer id);

    @Select("select * from city where id = #{id}")
    City getById(Integer id);

    @Select("select * from city where name = #{name}")
    City getByName(String name);

    @Select("select * from city")
    List<City> getAll();


}
