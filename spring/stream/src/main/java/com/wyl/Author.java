package com.wyl;

import lombok.*;

import java.util.List;

/**
 * @auther yanl.wang
 * @date 2023/3/8
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Author implements Comparable<Author>{
    private Long id;
    private String name;
    private Integer age;
    private String intro;
    private List<Book> books;


    @Override
    public int compareTo(Author o) {
        return o.getAge() - this.getAge();
    }
}
