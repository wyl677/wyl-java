package com.wyl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther yanl.wang
 * @date 2023/3/11
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer age;
    private String name;
}
