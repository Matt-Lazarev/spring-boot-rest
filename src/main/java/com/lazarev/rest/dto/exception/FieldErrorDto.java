package com.lazarev.rest.dto.exception;

public record FieldErrorDto(
        String field,
        String error
) { }
