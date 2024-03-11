package com.lazarev.rest.service;

import com.lazarev.rest.dto.UserDto;
import com.lazarev.rest.entity.User;
import com.lazarev.rest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto getUserById(Integer id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User with id = '%d' not found".formatted(id)));
        return new UserDto(user.getUsername(), user.getEmail());
    }
}
