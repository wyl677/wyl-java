package com.wyl;

import lombok.*;


/**
 * @auther yanl.wang
 * @date 2023/3/8
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {
    private Long id;
    private String name;
    private String category;
    private Integer score;
    private String intro;
}
