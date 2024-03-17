package ru.trofimov.bookshare.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "SwapRequest DTO")
public class SwapRequest {

    @Schema(description = "Requester id", example = "1")
    @NotNull(message = "Requester id must be not null!")
    private Long reqId;
    @Schema(description = "Requester's book id", example = "2")
    @NotNull(message = "Requester's book id must be not null!")
    private Long reqBookId;
    @Schema(description = "Responder id", example = "2")
    @NotNull(message = "Responder id must be not null!")
    private Long resId;
    @Schema(description = "Responder's book id", example = "4")
    @NotNull(message = "Responder's book id must be not null!")
    private Long resBookId;

    public Long getReqId() {
        return reqId;
    }

    public Long getReqBookId() {
        return reqBookId;
    }

    public Long getResId() {
        return resId;
    }

    public Long getResBookId() {
        return resBookId;
    }
}
