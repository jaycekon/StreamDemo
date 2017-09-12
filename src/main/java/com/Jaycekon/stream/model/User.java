package com.Jaycekon.stream.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * lombok Test
 * Created by Jaycekon on 2017/9/5.
 */

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
class User implements Serializable{
    private String name;
    private String sex;
    private String phone;


}
