package com.bank.authorization.repository;

import com.bank.authorization.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс, который берет на себя работу с БД
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}


