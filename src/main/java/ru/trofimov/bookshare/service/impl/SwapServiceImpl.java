package ru.trofimov.bookshare.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ru.trofimov.bookshare.domain.book.Book;
import ru.trofimov.bookshare.domain.book.Status;
import ru.trofimov.bookshare.domain.swap.Swap;
import ru.trofimov.bookshare.domain.user.User;
import ru.trofimov.bookshare.repository.SwapRepository;
import ru.trofimov.bookshare.service.BookService;
import ru.trofimov.bookshare.service.EmailService;
import ru.trofimov.bookshare.service.SwapService;
import ru.trofimov.bookshare.service.UserService;
import ru.trofimov.bookshare.web.dto.SwapDto;
import ru.trofimov.bookshare.web.dto.SwapRequest;
import ru.trofimov.bookshare.web.dto.SwapViewDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SwapServiceImpl implements SwapService {

    private final UserService userService;
    private final BookService bookService;
    private final SwapRepository swapRepository;
    private final EmailService emailService;

    public SwapServiceImpl(UserService userService, BookService bookService, SwapRepository swapRepository,
                           EmailService emailService) {
        this.userService = userService;
        this.bookService = bookService;
        this.swapRepository = swapRepository;
        this.emailService = emailService;
    }


    @Override
    public List<SwapViewDto> getRequests(Long reqId) {
        ArrayList<Swap> swaps = (ArrayList<Swap>) swapRepository.findByReqId(reqId);
        ArrayList<SwapViewDto> swapViewDtos = new ArrayList<>();
        for (Swap swap : swaps) {
            Book requesterBook = bookService.getBookById(swap.getReqBookId());
            Book responderBook = bookService.getBookById(swap.getResBookId());
            swapViewDtos.add(new SwapViewDto(swap.getId(), requesterBook.getName(), responderBook.getName()));
        }
        return swapViewDtos;
    }

    @Override
    public SwapDto swapBooks(Long swapId) {
        Optional<Swap> swap = swapRepository.findById(swapId);
        if (swap.isPresent()) {
            User requester = userService.getUserById(swap.get().getReqId());
            User responder = userService.getUserById(swap.get().getResId());
            Book requesterBook = bookService.getBookById(swap.get().getReqBookId());
            Book responderBook = bookService.getBookById(swap.get().getResBookId());

            requesterBook.setUserId(swap.get().getResId());
            responderBook.setUserId(swap.get().getReqId());
            requesterBook.setStatus(Status.AVAILABLE);
            responderBook.setStatus(Status.AVAILABLE);
            bookService.updateBook(requesterBook, swap.get().getReqBookId());
            bookService.updateBook(responderBook, swap.get().getResBookId());

            swapRepository.deleteById(swapId);

            return new SwapDto(
                    requester.getName(),
                    requester.getCity(),
                    requesterBook.getName(),
                    responder.getName(),
                    responder.getCity(),
                    responderBook.getName());
        } else {
            throw new EntityNotFoundException("Swap [" + swapId + "] not found!");
        }
    }

    @Override
    public SwapDto swapRequest(SwapRequest swapRequest) {
        User requester = userService.getUserById(swapRequest.getReqId());
        User responder = userService.getUserById(swapRequest.getResId());
        Book requesterBook = bookService.getBookById(swapRequest.getReqBookId());
        Book responderBook = bookService.getBookById(swapRequest.getResBookId());

        requesterBook.setStatus(Status.IN_EXCHANGE);
        responderBook.setStatus(Status.IN_EXCHANGE);

        Swap swap = new Swap(
                swapRequest.getReqId(),
                swapRequest.getReqBookId(),
                swapRequest.getResId(),
                swapRequest.getResBookId()
        );

        swapRepository.save(swap);

        SwapDto swapDto = new SwapDto(
                requester.getName(),
                requester.getCity(),
                requesterBook.getName(),
                responder.getName(),
                responder.getCity(),
                responderBook.getName()
        );

        final String body = "Пользователь " + requester.getName() +
                " c email: " + requester.getUsername() +
                " хочет поменять свою книгу: " + responderBook.getName() +
                " на вашу книгу: " + requesterBook.getName();

        emailService.sendEmailToUser(responder.getUsername(), "BookShare: ЗАПРОС НА ОБМЕН.", body);

        return swapDto;
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
