package com.yishuailuo.iTest.entity;

import com.yishuailuo.iTest.dto.CityDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created by luoyishuai on 17/7/29.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class City {

    private Integer id;
    private String name;
    private Integer area;
    private Integer pop;

    public CityDto toCityDto() {
        return CityDto.builder()
                .id(id)
                .name(name)
                .area(area)
                .pop(pop)
                .build();
    }
}
