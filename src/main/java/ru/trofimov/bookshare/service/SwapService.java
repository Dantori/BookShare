package ru.trofimov.bookshare.service;

import ru.trofimov.bookshare.web.dto.SwapDto;

public interface SwapService {

    SwapDto swapBooks(Long reqId, Long reqBookId, Long resId, Long resBookId);
    void setStatus(Long bookId);
}
