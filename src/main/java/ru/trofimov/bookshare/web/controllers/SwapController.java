package ru.trofimov.bookshare.web.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.trofimov.bookshare.service.SwapService;
import ru.trofimov.bookshare.web.dto.SwapDto;
import ru.trofimov.bookshare.web.dto.SwapRequest;

@RestController
@RequestMapping("/api/v1/swap")
@Tag(name = "Swap controller", description = "Swap API")
@Validated
public class SwapController {

    private final SwapService swapService;

    public SwapController(SwapService swapService) {
        this.swapService = swapService;
    }

    @PostMapping()
    public SwapDto swap(@Validated @RequestBody SwapRequest swapRequest) {
        return swapService.swapBooks(
                swapRequest.getReqId(),
                swapRequest.getReqBookId(),
                swapRequest.getResId(),
                swapRequest.getResBookId());
    }

    @PostMapping("/set_status/{bookId}")
    public void setStatus(@PathVariable Long bookId) {
        swapService.setStatus(bookId);
    }
}
