package ru.trofimov.bookshare.service;

import ru.trofimov.bookshare.domain.swap.Swap;
import ru.trofimov.bookshare.web.dto.SwapDto;
import ru.trofimov.bookshare.web.dto.SwapRequest;
import ru.trofimov.bookshare.web.dto.SwapViewDto;

import java.util.List;

public interface SwapService {

    List<SwapViewDto> getRequests(Long reqId);
    SwapDto swapBooks(Long swapId);
    SwapDto swapRequest(SwapRequest swapRequest);
    void setStatus(Long bookId);
}
