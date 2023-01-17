package com.bank.authorization.dto;

import com.bank.authorization.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link UserEntity} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    @NotNull
    private String role;
    @NotNull
    private Long profileId;
    @NotNull
    private String password;
}
