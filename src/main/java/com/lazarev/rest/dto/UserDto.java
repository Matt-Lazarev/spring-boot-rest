package com.lazarev.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;
    private String email;
}

// new UserDto(username, email) ->
// new User(userDto.getUsername(), userDto.getEmail()) ->
