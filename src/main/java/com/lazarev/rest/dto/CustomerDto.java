package com.lazarev.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CustomerDto(
        Integer id,

        @NotNull(message = "'firstname' cannot be null")
        String firstname,

        @NotNull(message = "'lastname' cannot be null")
        String lastname,

        @NotNull(message = "'age' cannot be null")
        @Positive(message = "'age' should be positive")
        Integer age,

        @NotNull(message = "'email' cannot be null")
        @Email(message = "Wrong email format")
        String email,

        @NotNull(message = "'password' cannot be null")
        @Size(min = 2, max = 10, message = "'password' should be from 2 to 10 symbols")
        String password
) { }
