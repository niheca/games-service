package com.example.gameservice.controllers.impl;

import com.example.gameservice.commons.dto.ErrorResponse;
import com.example.gameservice.commons.exceptions.GameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(value = {GameException.class})
    ResponseEntity<ErrorResponse> handleError(GameException gameException) {
        log.error("new Exception",gameException);
        var errorRespone = ErrorResponse.builder()
                .codeStatus(gameException.getHttpStatus().value())
                .message(gameException.getMessage())
                .build();
        return ResponseEntity.status(gameException.getHttpStatus()).body(errorRespone);
    }
}
