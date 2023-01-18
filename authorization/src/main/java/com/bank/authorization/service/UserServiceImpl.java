package com.bank.authorization.service;

import com.bank.authorization.dto.UserDto;
import com.bank.authorization.mapper.UserMapper;
import com.bank.authorization.model.UserEntity;
import com.bank.authorization.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDTO).toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        final UserEntity user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Пользователь с id " + id + " не найден!"));
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

    @Override
    public List<UserDto> getUsersByIds(List<Long> ids) {
        return ids.stream()
                .map(x -> userRepository.findById(x).orElseThrow(
                        () -> new EntityNotFoundException("Пользователь с id " + x + " не найден!")))
                .map(userMapper::toDTO)
                .toList();
    }
}
