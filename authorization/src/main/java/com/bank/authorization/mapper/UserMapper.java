package com.bank.authorization.mapper;

import com.bank.authorization.dto.UserDto;
import com.bank.authorization.model.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Маппер, который преобразует дто в энтити и обратно
 */
@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    UserDto toDTO(UserEntity userEntity);

    UserEntity toEntity(UserDto userDto);
}

