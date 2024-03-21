package ru.trofimov.bookshare.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "SwapRequest DTO")
public class SwapRequest {

    @Schema(description = "Id просителя", example = "1")
    @NotNull(message = "Requester id must be not null!")
    private final Long reqId;
    @Schema(description = "Id книги просителя", example = "2")
    @NotNull(message = "Requester's book id must be not null!")
    private final Long reqBookId;
    @Schema(description = "Id ответчика", example = "2")
    @NotNull(message = "Responder id must be not null!")
    private final Long resId;
    @Schema(description = "Id книги ответчика", example = "4")
    @NotNull(message = "Responder's book id must be not null!")
    private final Long resBookId;

    public SwapRequest(Long reqId, Long reqBookId, Long resId, Long resBookId) {
        this.reqId = reqId;
        this.reqBookId = reqBookId;
        this.resId = resId;
        this.resBookId = resBookId;
    }

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
