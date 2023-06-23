package com.yearup.reviewapi.controllers;

import com.yearup.reviewapi.dao.interfaces.IBookDao;
import com.yearup.reviewapi.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private IBookDao bookDao;

    @Autowired
    public BookController(IBookDao bookDao) {
        this.bookDao = bookDao;
    }

/*    @GetMapping
    //@RequestMapping(path = "/books", method = RequestMethod.GET)
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }*/

    @GetMapping
    //@RequestMapping(path = "/books", method = RequestMethod.GET)
    public List<Book> getAllBooks(@RequestParam(name = "title", required = false) String title,
                                  @RequestParam(name = "author", required = false) String author,
                                  @RequestParam(name = "year", required = false) Integer publicationYear) {
        return bookDao.getAllBooks(title, author, publicationYear);
    }

    @GetMapping("/{id}")
    //@RequestMapping(path = "/books/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable int id) {
        return bookDao.getBookById(id);
    }

    @PostMapping
    //@RequestMapping(path = "/books", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return bookDao.addBook(book);
    }

    @PutMapping("/{id}")
    //@RequestMapping(path = "/books/{id}", method = RequestMethod.PUT)
    public void updateBook(@PathVariable int id, @RequestBody Book book) {
        bookDao.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    //@RequestMapping(path = "/books/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        bookDao.deleteBook(id);
    }
}

