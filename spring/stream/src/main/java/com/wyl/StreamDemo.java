package com.wyl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;


/**
 * @auther yanl.wang
 * @date 2023/3/8
 * 函数式编程
 *  1.创建流
 *      单列集合：集合对象.stream()
 *      数组：Arrays.stream(arr)或Stream.of(arr)
 *      双列集合：map.entrySet().stream()
 *  2.中间操作
 *      filter:可以对流中的元素进行条件过滤，符合过滤条件的才能继续留在流中。Predicate断言
 *      map:可以把对流中的元素进行计算或转换.Function<Author, Object>目标对象转返回对象。
 *      distinct:去重，重写equals(),不然Object的equals()比较的是对象的内存地址。
 *      sorted:可以对流中的元素进行排序.元素对象实现Comparable接口重写compareTo方法，或者在有参sorted重写
 *      limit:可以设置流的最大长度，超出部分将被抛弃
 *      skip:跳过流中的前n个元素，返回剩下的元素。
 *      flatMap:一个对象转换成多个对象作为流中的元素。Function<Author, Stream<Book>>
 *  3.终结操作
 *
 *
 *
 **/
public class StreamDemo {
    public static void main(String[] args) {

        //打印所有年龄小于18的作家的名字，并且注意去重
        /*List<Author> authors = getAuthors();
        authors.stream() //把集合转换成流
                .distinct()
                .filter(author -> author.getAge()<18)
                .forEach(author -> System.out.println(author.getName()));*/

        //打印书籍的名字，对重复的元素去重
        /*getAuthors().stream()
                .flatMap( author -> author.getBooks().stream() )
                .distinct()
                .forEach( book -> System.out.println(book.getName()) );*/

        //打印现有数据的所有分类，要求对分类进行去重，不能出现这种格式：哲学,爱情
        getAuthors().stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(category -> System.out.println(category));

    }

    private static List<Author> getAuthors(){
        //数据初始化
        Author author1 = new Author(1L, "梦多", 33, "一个从才到中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚索", 12, "疾风剑豪", null);
        Author author3 = new Author(3L, "剑圣", 13, "疾走哈哈哈", null);
        Author author4 = new Author(3L, "剑圣", 13, "疾走哈哈哈", null);

        //书籍列表
        List<Book> books1 = new ArrayList<Book>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L,"哈哈","哲学,爱情",88,"asdf"));
        books1.add(new Book(2L,"哈哈2","社会鞋,爱情",77,"设施"));

        books2.add(new Book(3L,"哈哈3","社会鞋,爱情3",73,"设施3"));
        books2.add(new Book(4L,"哈哈4","社会鞋,爱情4",74,"设施4"));
        books2.add(new Book(5L,"哈哈5","社会鞋,爱情5",75,"设施5"));

        books3.add(new Book(6L,"哈哈6","社会鞋,爱情6",76,"设施6"));
        books3.add(new Book(7L,"哈哈7","社会鞋,爱情7",77,"设施7"));
        books3.add(new Book(8L,"哈哈8","社会鞋,爱情8",78,"设施8"));

       author1.setBooks(books1);
       author2.setBooks(books2);
       author3.setBooks(books3);
       author4.setBooks(books3);

       List<Author> authorList = new ArrayList<>(Arrays.asList(author1,author2,author3,author4));
       return authorList;
    }
}
