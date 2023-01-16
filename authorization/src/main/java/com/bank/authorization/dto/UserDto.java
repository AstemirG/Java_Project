package com.bank.authorization.dto;

import com.bank.authorization.model.UserEntity;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link UserEntity} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    @Size(max = 40)
    @NotNull
    private String role;
    @NotNull
    private Long profileId;
    @Size(max = 500)
    @NotNull
    private String password;
}