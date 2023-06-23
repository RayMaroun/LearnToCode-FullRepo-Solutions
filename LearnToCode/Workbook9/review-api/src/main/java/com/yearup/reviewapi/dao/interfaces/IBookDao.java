package com.yearup.reviewapi.dao.interfaces;

import com.yearup.reviewapi.models.Book;

import java.util.List;

public interface IBookDao {
    //List<Book> getAllBooks();
    List<Book> getAllBooks(String title, String author, Integer publicationYear);
    Book getBookById(int id);
    Book addBook(Book book);
    void updateBook(int id, Book book);
    void deleteBook(int id);
}
