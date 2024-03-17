package ru.trofimov.bookshare.web.mappre;

import org.mapstruct.Mapper;
import ru.trofimov.bookshare.domain.book.Book;
import ru.trofimov.bookshare.web.dto.BookDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto toDto(Book book);

    List<BookDto> toDto(List<Book> books);

    Book toEntity(BookDto bookDto);
}
