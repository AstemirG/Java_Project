package com.bank.authorization.repository;

import com.bank.authorization.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    //@Query(value = "select * from users where id = ?",nativeQuery = true)
    //Optional<UserEntity> findById(Long id);
}
