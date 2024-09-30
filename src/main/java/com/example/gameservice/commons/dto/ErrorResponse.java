package com.example.gameservice.commons.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private Integer codeStatus;
    private String message;

}
