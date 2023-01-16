package com.bank.authorization.service;

import com.bank.authorization.dto.UserDto;
import com.bank.authorization.mapper.UserMapper;
import com.bank.authorization.model.UserEntity;
import com.bank.authorization.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println("----------------------------------");
        System.out.println(userRepository.findAll());
        System.out.println("----------------------------------");
        return null;
    }

    @Override
    public UserDto getUserById(Long id) {
        return userMapper.toDTO(userRepository.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public UserDto saveUser(UserDto userDto) {
        UserEntity userEntity = userMapper.toEntity(userDto);
        userRepository.save(userEntity);
        return userDto;
    }

    @Override
    @Transactional
    public UserDto updateUser(Long id, UserDto userDto) {
        UserEntity userEntity = userMapper.toEntity(userDto);
        userRepository.save(userEntity);
        return userDto;
    }
}
