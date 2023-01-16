package com.bank.authorization.service;

import com.bank.authorization.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> getAllUsers();
    public UserDto getUserById(Long id);
    public UserDto saveUser(UserDto userDto);
    public UserDto updateUser(Long id, UserDto userDto);
}
