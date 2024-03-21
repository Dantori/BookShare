package ru.trofimov.bookshare.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "SwapViewDto")
public class SwapViewDto {

    @Schema(description = "Id записи обмена", example = "1")
    private final Long id;
    @Schema(description = "Книга просителя обмена", example = "Илья")
    private final String requesterBookName;

    @Schema(description = "Книга ответчика на запрос об обмене", example = "Филип")
    private final String responderBookName;

    public SwapViewDto(Long id, String requesterBookName, String responderBookName) {
        this.id = id;
        this.requesterBookName = requesterBookName;
        this.responderBookName = responderBookName;
    }

    public Long getId() {
        return id;
    }

    public String getRequesterBookName() {
        return requesterBookName;
    }

    public String getResponderBookName() {
        return responderBookName;
    }
}
