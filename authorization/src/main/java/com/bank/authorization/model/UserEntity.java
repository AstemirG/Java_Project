package com.bank.authorization.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Класс сущности, который связан с таблицей в БД
 */
@Entity
@Table(name = "users", schema = "auth")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "id")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "role", nullable = false)
    private String role;

    @NotNull
    @Column(name = "profile_id", nullable = false)
    private Long profileId;

    @NotNull
    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(role, that.role) &&
                Objects.equals(profileId, that.profileId) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, profileId, password);
    }
}
