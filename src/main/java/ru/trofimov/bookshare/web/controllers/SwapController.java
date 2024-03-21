package ru.trofimov.bookshare.web.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.trofimov.bookshare.service.SwapService;
import ru.trofimov.bookshare.web.dto.SwapDto;
import ru.trofimov.bookshare.web.dto.SwapRequest;
import ru.trofimov.bookshare.web.dto.SwapViewDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/swap")
@Tag(name = "Swap controller", description = "Swap API")
@Validated
public class SwapController {

    private final SwapService swapService;

    public SwapController(SwapService swapService) {
        this.swapService = swapService;
    }

    @PostMapping("/request")
    @Operation(summary = "Запрос на обмен книгами")
    public SwapDto request(@Validated @RequestBody SwapRequest swapRequest) {
        return swapService.swapRequest(swapRequest);
    }

    @GetMapping("/check_requests/{reqId}")
    @Operation(summary = "Посмотреть список запросов на обмен")
    public List<SwapViewDto> checkRequests(@PathVariable Long reqId) {
        return swapService.getRequests(reqId);
    }

    @PostMapping("/confirm/{swapId}")
    @Operation(summary = "Подтвердить обмен по id записи обмена")
    public SwapDto confirm(@PathVariable Long swapId) {
        return swapService.swapBooks(swapId);
    }

    @PostMapping("/set_status/{bookId}")
    @Operation(summary = "Поменять статус книги")
    public void setStatus(@PathVariable Long bookId) {
        swapService.setStatus(bookId);
    }
}
