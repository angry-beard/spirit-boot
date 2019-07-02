package org.angrybeard.spiritboot.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by angry_beary on 2019/7/2.
 * 性能：jackson>fastJson>Gson>json-lib
 * 该dto 使用的jackson注解
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer age;
    @JsonProperty("gender")
    private String sex;
    private String phone;
    @JsonIgnore
    private String creditCard;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date birthDay;
}
