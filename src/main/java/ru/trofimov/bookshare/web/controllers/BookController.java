package ru.trofimov.bookshare.web.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.trofimov.bookshare.service.BookService;
import ru.trofimov.bookshare.web.dto.BookDto;
import ru.trofimov.bookshare.web.mappre.BookMapper;
import ru.trofimov.bookshare.web.validation.OnCreate;
import ru.trofimov.bookshare.web.validation.OnUpdate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@Tag(name = "Book controller", description = "Book API")
@Validated
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping("/add_book")
    @Operation(summary = "Add book by id")
    public void addBook(@Validated(OnCreate.class) @RequestBody BookDto bookDto) {
        bookService.addBook(bookMapper.toEntity(bookDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by id")
    public BookDto getUser(@PathVariable Long id) {
        return bookMapper.toDto(bookService.getBookById(id));
    }

    @GetMapping("/get_all_books")
    @Operation(summary = "Get all books")
    public List<BookDto> getAllBooks() {
        return bookMapper.toDto(bookService.getAllBooks());
    }

    @GetMapping("/get_all_books_by_userId/{userId}")
    @Operation(summary = "Get all books by user id")
    public List<BookDto> getAllBooksByUserId(@PathVariable Long userId) {
        return bookMapper.toDto(bookService.getAllBookByUserId(userId));
    }

    @PostMapping("/update/{id}")
    @Operation(summary = "Update book by id")
    public void updateBook(@Validated(OnUpdate.class) @RequestBody BookDto bookDto, Long id) {
        bookService.updateBook(bookMapper.toEntity(bookDto), id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete book by id")
    public void deleteUser(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }
}
