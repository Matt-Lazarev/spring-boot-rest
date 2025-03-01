package com.lazarev.rest.dto.exception;

public record ErrorResponse (
        Integer status,
        String message
) { }
