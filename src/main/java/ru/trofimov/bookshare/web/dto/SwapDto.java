package ru.trofimov.bookshare.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Swap DTO")
public class SwapDto {

    @Schema(description = "Requester name", example = "Илья")
    private String requesterName;

    @Schema(description = "Requester city", example = "Рязань")
    private String requesterCity;

    @Schema(description = "Requester's book name", example = "Преступление и наказание")
    private String requestersBookName;

    @Schema(description = "Responder name", example = "Филип")
    private String responderName;

    @Schema(description = "Responder city", example = "Москва")
    private String responderCity;

    @Schema(description = "Responder's book name", example = "Гарри Поттер и философский камень")
    private String responderBookName;

    public SwapDto(String requesterName, String requesterCity, String requestersBookName, String responderName,
                   String responderCity, String responderBookName) {
        this.requesterName = requesterName;
        this.requesterCity = requesterCity;
        this.requestersBookName = requestersBookName;
        this.responderName = responderName;
        this.responderCity = responderCity;
        this.responderBookName = responderBookName;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getRequesterCity() {
        return requesterCity;
    }

    public void setRequesterCity(String requesterCity) {
        this.requesterCity = requesterCity;
    }

    public String getRequestersBookName() {
        return requestersBookName;
    }

    public void setRequestersBookName(String requestersBookName) {
        this.requestersBookName = requestersBookName;
    }

    public String getResponderName() {
        return responderName;
    }

    public void setResponderName(String responderName) {
        this.responderName = responderName;
    }

    public String getResponderCity() {
        return responderCity;
    }

    public void setResponderCity(String responderCity) {
        this.responderCity = responderCity;
    }

    public String getResponderBookName() {
        return responderBookName;
    }

    public void setResponderBookName(String responderBookName) {
        this.responderBookName = responderBookName;
    }
}
