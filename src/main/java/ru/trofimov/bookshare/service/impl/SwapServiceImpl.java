package ru.trofimov.bookshare.service.impl;

import org.springframework.stereotype.Service;
import ru.trofimov.bookshare.domain.book.Book;
import ru.trofimov.bookshare.domain.book.Status;
import ru.trofimov.bookshare.domain.user.User;
import ru.trofimov.bookshare.service.BookService;
import ru.trofimov.bookshare.service.SwapService;
import ru.trofimov.bookshare.service.UserService;
import ru.trofimov.bookshare.web.dto.SwapDto;

@Service
public class SwapServiceImpl implements SwapService {

    private final UserService userService;
    private final BookService bookService;

    public SwapServiceImpl(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @Override
    public SwapDto swapBooks(Long reqId, Long reqBookId, Long resId, Long resBookId) {
        User requester = userService.getUserById(reqId);
        User responder = userService.getUserById(resId);
        Book requestersBook = bookService.getBookById(reqBookId);
        Book responderBook = bookService.getBookById(resBookId);

        requestersBook.setStatus(Status.IN_EXCHANGE);
        responderBook.setStatus(Status.IN_EXCHANGE);

        requestersBook.setUserId(resId);
        bookService.updateBook(requestersBook, reqBookId);
        responderBook.setUserId(reqId);
        bookService.updateBook(responderBook, resBookId);

        return new SwapDto(
                requester.getName(),
                requester.getCity(),
                requestersBook.getName(),
                responder.getName(),
                responder.getCity(),
                responderBook.getName()
        );
    }

    @Override
    public void setStatus(Long bookId) {
        Book book = bookService.getBookById(bookId);
        if (book.getStatus().equals(Status.IN_EXCHANGE)) {
            book.setStatus(Status.AVAILABLE);
        } else  {
            book.setStatus(Status.IN_EXCHANGE);
        }
        bookService.updateBook(book, bookId);
    }
}
