package com.bank.authorization.service;

import com.bank.authorization.dto.UserDto;
import com.bank.authorization.mapper.UserMapper;
import com.bank.authorization.model.UserEntity;
import com.bank.authorization.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public List<UserDto> getAllUsers() {
        System.out.println(userRepository.findAll());
        return null;
    }

    @Override
    public UserDto getUserById(Long id) {
        final UserEntity user = userRepository.findById(id).orElse(null);
        return userMapper.toDTO(user);
    }

    @Override
    @Transactional
    public UserDto saveUser(UserDto userDto) {
        final UserEntity userEntity = userMapper.toEntity(userDto);
        userRepository.save(userEntity);
        return userDto;
    }

    @Override
    @Transactional
    public UserDto updateUser(Long id, UserDto userDto) {
        final UserEntity userEntity = userMapper.toEntity(userDto);
        userRepository.save(userEntity);
        return userDto;
    }
}
