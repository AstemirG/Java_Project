package com.bank.authorization.service;

import com.bank.authorization.dto.UserDto;

import java.util.List;

/**
 * Интерфейс класса с бизнес-логикой
 */
public interface UserService {
    UserDto getUserById(Long id);
    UserDto saveUser(UserDto userDto);
    UserDto updateUser(Long id, UserDto userDto);
    List<UserDto> getUsersByIds(List<Long> id);
}

