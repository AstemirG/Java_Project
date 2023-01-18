package com.bank.authorization.repository;

import com.bank.authorization.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "SELECT * FROM \"authorization\".user WHERE id = ?;", nativeQuery = true)
    Optional<UserEntity> findById(@Param("id") Long id);

    @Query(value = "SELECT * FROM \"authorization\".user ", nativeQuery = true)
    List<UserEntity> findAll();


}


