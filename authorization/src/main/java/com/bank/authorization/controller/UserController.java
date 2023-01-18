package com.bank.authorization.controller;

import com.bank.authorization.dto.UserDto;
import com.bank.authorization.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest контроллер, который взаимодействует с другими микросервисами
 */
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * @param userDto Данные нового пользователя которые передаются в сервис
     * @return Возвращает сохраненного пользователя
     */
    @PostMapping("/createNewUser")
    public ResponseEntity<UserDto> createNewUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.OK);
    }

    /**
     * @param id id пользователя, которого надо найти
     * @return Возвращает пользователя из БД
     */
    @GetMapping("/{id}/get")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    /**
     * @param id id по которому существующего пользователя сервис будет искать в БД
     * @param userDto Данные которые надо сохранить
     * @return Возвращает обновленного пользователя
     */
    @PutMapping("/{id}/update")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.updateUser(id, userDto), HttpStatus.OK);
    }

    /**
     * @param id Список id, который надо найти
     * @return Возвращает список юзеров по id
     */
    @GetMapping("/getUsers")
    public ResponseEntity<List<UserDto>> getUsersByIds(@RequestParam List<Long> id) {
        return new ResponseEntity<>(userService.getUsersByIds(id), HttpStatus.OK);
    }

}

