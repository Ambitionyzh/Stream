package com.yongzh;

import com.yongzh.ENTITY.Author;
import com.yongzh.ENTITY.Book;
import lombok.val;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/7/3 22:21
 */
public class StreamDemo {

    public static void main(String[] args) {
        //extracted();
        //extracted1();
        //extracted2();
        //extracted3();
       // extracted4();
        //extracted5();
        //extracted6();
       // extracted7();
       // extracted8();
        //extracted9();
       // extracted10();
        //extracted11();
        //extracted12();
        //extracted13();
        extracted14();
    }
    //返回作家的最大年龄
    private static void extracted14() {
        List<Author> authors = getAuthors();
        System.out.println(authors.stream().map(author -> author.getAge())
                .reduce(0, (result, element) -> result>element?result:element));
        System.out.println(authors.stream().map(author -> author.getAge())
                .reduce( (result, element) -> result>element?result:element));
    }

    //使用reduce求所有作家年龄的和
    private static void extracted13() {
        List<Author> authors = getAuthors();
        System.out.println(authors.stream().map(author -> author.getAge())
                .reduce(0, (result, element) -> result + element));
    }

    private static void extracted12() {
        List<Author> authors = getAuthors();
        System.out.println(authors.stream().allMatch(author -> author.getAge() > 10));
    }

    //获取年龄29岁以上的作家
    private static void extracted11() {
        List<Author> authors = getAuthors();
        System.out.println(authors.stream().anyMatch(author -> author.getAge() > 26));
    }

    //获取作家名和书名的Map集合
    private static void extracted10() {
        List<Author> authors = getAuthors();
        Map<String, List<Book>> bookMap = authors.stream().distinct().collect
                (Collectors.toMap(author -> author.getName(), author -> author.getBookList()));
        System.out.println(bookMap);
    }


    //获取所有书名的Set集合
    private static void extracted9() {
        List<Author> authors = getAuthors();
        Set<Book> books = authors.stream().flatMap(author -> author.getBookList()
                .stream()).collect(Collectors.toSet());
        System.out.println(books);
    }

    //获取所有作家名字的list
    private static void extracted8() {
        List<Author> authors = getAuthors();
        List<String> nameList =  authors.stream().map(author -> author.getName()).distinct()
                .collect(Collectors.toList());
        System.out.println(nameList);
    }

    // 分别获取这些作家的所出书籍的最高分和最低分并打印
    private static void extracted7() {
        List<Author> authors = getAuthors();
        Optional<Double> max = authors.stream()
                .flatMap(author -> author.getBookList().stream())
                .map(book -> book.getScore())
                .max((score1, score2) -> (int) (score1 - score2));
        Optional<Double> min = authors.stream()
                .flatMap(author -> author.getBookList().stream())
                .map(book -> book.getScore())
                .min((score1, score2) -> (int) (score1 - score2));
        System.out.println(max.get());
        System.out.println(min.get());

    }
    // 打印这些作家所出书籍的数目，注意删除重复元素
    private static void extracted6() {
        List<Author> authors = getAuthors();
        long count = authors.stream()
                .flatMap(author -> author.getBookList().stream())
                .distinct().count();
        System.out.println(count);
    }
    //输出所有作家的名字
    private static void extracted5() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBookList().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getName().split(",")))
                .forEach(name-> System.out.println(name));
    }

    private static void extracted4() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o1.getAge()-o2.getAge())
                .skip(2)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void extracted3() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted()
                .limit(2)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void extracted2() {
        List<Author> authors= getAuthors();
        authors.stream().sorted((o1, o2) -> o1.getAge()-o2.getAge()).
                forEach(author -> System.out.println(author.getAge()));
    }

    private static void extracted1() {
        List<Author> authors= getAuthors();
        authors.stream()
                .map(author -> author.getName())
                .forEach(s -> System.out.println(s));
    }

    private static void extracted() {
        List<Author> authors = getAuthors();
        authors.stream()
               .distinct()
               .filter(author -> author.getAge() < 18)
                       .forEach(author -> System.out.println(author.getName()));
        System.out.println(authors);
    }

    // 初始化一些数据
    private static List<Author> getAuthors() {
        Author author1 = new Author(1L, "wuhu", "my introduction 1", 18, null);
        Author author2 = new Author(2L, "qifei", "my introduction 2", 19, null);
        Author author3 = new Author(3L, "roudan", "my introduction 3", 14, null);
        Author author4 = new Author(4L, "congji", "my introduction 4", 29, null);
        Author author5 = new Author(5L, "wtf", "my introduction 5", 12, null);
        Author author6 = new Author(5L, "wtf", "my introduction 5", 12, null);

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();
        List<Book> books4 = new ArrayList<>();

        // 上面是作者和书
        books1.add(new Book(1L, "类别,分类啊", "书名1", 45D, "这是简介哦"));
        books1.add(new Book(2L, "高效", "书名2", 84D, "这是简介哦"));
        books1.add(new Book(3L, "喜剧", "书名3", 83D, "这是简介哦"));

        books2.add(new Book(5L, "天啊", "书名4", 65D, "这是简介哦"));
        books2.add(new Book(6L, "高效", "书名5", 89D, "这是简介哦"));

        books3.add(new Book(7L, "久啊", "书名6", 45D, "这是简介哦"));
        books3.add(new Book(8L, "高效", "书名7", 44D, "这是简介哦"));
        books3.add(new Book(9L, "喜剧", "书名8", 81D, "这是简介哦"));

        books4.add(new Book(10L, "喜剧", "wuhu", 65D, "这是简介哦"));
        books4.add(new Book(12L, "悲剧", "qifei", 89D, "这是简介哦"));

        author1.setBookList(books1);
        author2.setBookList(books2);
        author3.setBookList(books3);
        author4.setBookList(books3);
        author5.setBookList(books2);
        author6.setBookList(books2);


        return new ArrayList<>(Arrays.asList(author1, author2, author3, author4, author5, author6));
    }

}
