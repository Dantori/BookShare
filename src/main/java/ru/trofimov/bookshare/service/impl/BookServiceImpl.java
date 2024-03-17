package ru.trofimov.bookshare.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ru.trofimov.bookshare.domain.book.Book;
import ru.trofimov.bookshare.domain.book.Status;
import ru.trofimov.bookshare.repository.BookRepository;
import ru.trofimov.bookshare.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(Book book) {
        book.setStatus(Status.AVAILABLE);
        bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        Optional<Book> bookFromDb = bookRepository.findById(id);
        return bookFromDb
                .orElseThrow(() -> new EntityNotFoundException("Book [" + id + "] not found!"));
    }

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public List<Book> getAllBookByUserId(Long userId) {
        return (List<Book>) bookRepository.findAllByUserId(userId);
    }

    @Override
    public void updateBook(Book book, Long id) {
        Optional<Book> bookFromDb = bookRepository.findById(id);
        if(bookFromDb.isPresent()) {
            bookFromDb.get().setName(book.getName());
            bookFromDb.get().setDescription(book.getDescription());
            bookFromDb.get().setStatus(book.getStatus());
            bookRepository.save(bookFromDb.get());
        } else {
            throw new IllegalStateException("Book [" + id + "] not exists!");
        }
    }

    @Override
    public void deleteBookById(Long id) {
        Optional<Book> bookFromDb = bookRepository.findById(id);
        if (bookFromDb.isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Book [" + id + "] not exists!");
        }
    }
}
