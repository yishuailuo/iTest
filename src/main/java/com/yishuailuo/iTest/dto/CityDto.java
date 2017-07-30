package com.yishuailuo.iTest.dto;

import com.yishuailuo.iTest.entity.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

/**
 * Created by luoyishuai on 17/7/30.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {

    private Integer id;

    @NotEmpty
    private String name;
    @Min(1)
    private Integer area;
    @Min(1)
    private Integer pop;

    public City toCity() {
        return City.builder()
                .id(id)
                .name(name)
                .area(area)
                .pop(pop)
                .build();
    }
}
