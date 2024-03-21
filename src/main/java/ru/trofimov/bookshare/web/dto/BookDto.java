package ru.trofimov.bookshare.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import ru.trofimov.bookshare.domain.book.Status;
import ru.trofimov.bookshare.web.validation.OnCreate;
import ru.trofimov.bookshare.web.validation.OnUpdate;

@Schema(description = "Book DTO")
public class BookDto {

    @Schema(description = "Id книги", example = "1")
    @NotNull(message = "Id must be not null!", groups = OnUpdate.class)
    private Long id;

    @Schema(description = "id владельца", example = "1")
    @NotNull(message = "Id must be not null!", groups = OnCreate.class)
    private Long userId;

    @Schema(description = "Название книги", example = "Преступление и наказание")
    @NotNull(message = "Name must be not null!", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length mast be smaller than 255", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @Schema(description = "Описание книги", example = "Русская классика")
    @Length(max = 255, message = "Description length mast be smaller than 255", groups = {OnCreate.class, OnUpdate.class})
    private String description;

    @Schema(description = "Статус книги", example = "AVAILABLE")
    @NotNull(message = "Status must be not null!", groups = OnUpdate.class)
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}