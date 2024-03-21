package ru.trofimov.bookshare.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Swap DTO")
public class SwapDto {

    @Schema(description = "Requester name", example = "Илья")
    private final String requesterName;

    @Schema(description = "Requester city", example = "Рязань")
    private final String requesterCity;

    @Schema(description = "Requester's book name", example = "Преступление и наказание")
    private final String requestersBookName;

    @Schema(description = "Responder name", example = "Филип")
    private final String responderName;

    @Schema(description = "Responder city", example = "Москва")
    private final String responderCity;

    @Schema(description = "Responder's book name", example = "Гарри Поттер и философский камень")
    private final String responderBookName;

    public SwapDto(String requesterName, String requesterCity, String requestersBookName, String responderName,
                   String responderCity, String responderBookName) {
        this.requesterName = requesterName;
        this.requesterCity = requesterCity;
        this.requestersBookName = requestersBookName;
        this.responderName = responderName;
        this.responderCity = responderCity;
        this.responderBookName = responderBookName;
    }

    public String getRequesterName() {return requesterName;}
    public String getRequesterCity() {
        return requesterCity;
    }
    public String getRequestersBookName() {
        return requestersBookName;
    }
    public String getResponderName() {
        return responderName;
    }
    public String getResponderCity() {
        return responderCity;
    }
    public String getResponderBookName() {
        return responderBookName;
    }

}
