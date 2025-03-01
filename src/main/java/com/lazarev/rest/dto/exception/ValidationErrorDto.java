package com.lazarev.rest.dto.exception;

import java.util.List;

public record ValidationErrorDto(
        Integer status,
        List<FieldErrorDto> errors
) { }
