package ru.trofimov.bookshare.service;

import ru.trofimov.bookshare.domain.book.Book;
import ru.trofimov.bookshare.domain.user.User;

import java.util.List;

public interface BookService {

    void addBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    List<Book> getAllBookByUserId(Long userId);
    void updateBook(Book book, Long id);
    void deleteBookById(Long userId);
}
