package ru.trofimov.bookshare.web.mappre;

import org.mapstruct.Mapper;
import ru.trofimov.bookshare.domain.user.User;
import ru.trofimov.bookshare.web.dto.UserDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
    List<UserDto> toDto(List<User> users);
    User toEntity(UserDto userDto);
}
