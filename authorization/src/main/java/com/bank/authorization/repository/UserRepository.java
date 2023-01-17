package com.bank.authorization.repository;

import com.bank.authorization.model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
    @Query(value = "SELECT * FROM \"authorization\".user WHERE id = ?;", nativeQuery = true)
    Optional<UserEntity> findById(@Param("id") Long id);
}
