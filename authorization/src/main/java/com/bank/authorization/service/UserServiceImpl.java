package com.bank.authorization.service;

import com.bank.authorization.dto.UserDto;
import com.bank.authorization.mapper.UserMapper;
import com.bank.authorization.model.UserEntity;
import com.bank.authorization.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;


/**
 * Класс в котором происходит вся бизнес-логика, мапинг между энтити и дто
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    /**
     * @param id id пользователя, которого необходимо найти.
     *  Метод, который находит в базе пользователя по id преобразует в дто и отдает контроллеру
     * @return ДТО одного пользователя
     */
    @Override
    public UserDto getUserById(Long id) {
        final UserEntity user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Пользователь с id " + id + " не найден!"));
        return userMapper.toDTO(user);
    }

    /**
     * @param userDto Пользователь которого надо сохранить
     * @return Возвращает сохраненного пользователя
     */
    @Override
    @Transactional
    public UserDto saveUser(UserDto userDto) {
        final UserEntity userEntity = userMapper.toEntity(userDto);
        userRepository.save(userEntity);
        return userDto;
    }

    /**
     * @param id id Пользователя, который записывается в dto и обновляется
     * @param userDto Все остальные данные который передаются для обновления
     * @return Возвращает обновленного пользователя
     */
    @Override
    @Transactional
    public UserDto updateUser(Long id, UserDto userDto) {
        userDto.setId(id);
        final UserEntity userEntity = userMapper.toEntity(userDto);
        userRepository.save(userEntity);
        return userDto;
    }

    /**
     * @param ids Лист id пользователей, которых надо найти
     * @return Возвращает список найденных пользователей в виде dto
     */
    @Override
    public List<UserDto> getUsersByIds(List<Long> ids) {
        return ids.stream()
                .map(x -> userRepository.findById(x).orElseThrow(
                        () -> new EntityNotFoundException("Юзера с id " + x + " нет!")))
                .map(userMapper::toDTO)
                .toList();
    }
}
