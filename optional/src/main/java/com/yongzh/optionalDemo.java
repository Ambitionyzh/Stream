package com.yongzh;

import com.yongzh.entity.Author;
import com.yongzh.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class optionalDemo {
    public static void main(String[] args) {
        Optional<Author> authors = getAuthors();
        authors.ifPresent(author -> System.out.println(author.getName()));
        Author author = authors.orElseGet(()-> new Author());
        System.out.println(author.getName());

    }
    private static Optional<Author> getAuthors() {
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


        return Optional.ofNullable(author3);
    }
}