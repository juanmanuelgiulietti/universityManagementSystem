package io.github.juanmanuelgiulietti.ums.exception.dto;

import java.time.OffsetDateTime;
import java.util.List;

public record ErrorResponse (
    OffsetDateTime timestamp,
    int status,
    String message,
    List<String> errors,
    String path
){}
    
