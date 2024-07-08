package com.yongzh;

import com.yongzh.ENTITY.Author;
import com.yongzh.ENTITY.Book;
import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
        extracted4();
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

        // 上面是作者和书
        books1.add(new Book(1L, "类别,分类啊", "书名1", 45D, "这是简介哦"));
        books1.add(new Book(2L, "高效", "书名2", 84D, "这是简介哦"));
        books1.add(new Book(3L, "喜剧", "书名3", 83D, "这是简介哦"));

        books2.add(new Book(5L, "天啊", "书名4", 65D, "这是简介哦"));
        books2.add(new Book(6L, "高效", "书名5", 89D, "这是简介哦"));

        books3.add(new Book(7L, "久啊", "书名6", 45D, "这是简介哦"));
        books3.add(new Book(8L, "高效", "书名7", 44D, "这是简介哦"));
        books3.add(new Book(9L, "喜剧", "书名8", 81D, "这是简介哦"));

        author1.setBookList(books1);
        author2.setBookList(books2);
        author3.setBookList(books3);
        author4.setBookList(books3);
        author5.setBookList(books2);

        return new ArrayList<>(Arrays.asList(author1, author2, author3, author4, author5, author6));
    }

}
