package com.bida.logoeat.logoeat.repository;

import com.bida.logoeat.logoeat.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByPhoneNumber(String phoneNumber);

    @Modifying
    @Transactional
    @Query(value = "update users\n" +
            "set password = :newPassword\n" +
            "where id = :id",
            nativeQuery = true)
    void updatePasswordById(Long id, String newPassword);

    @Modifying
    @Transactional
    @Query(value = "update users\n" +
            "set phone_number = :newPhoneNumber\n" +
            "where email = :email",
            nativeQuery = true)
    void updatePhoneNumberByEmail(String email, String newPhoneNumber);

    @Modifying
    @Transactional
    @Query(value = "update users\n" +
            "set name = :newName\n" +
            "where email = :email",
            nativeQuery = true)
    void updateNameByEmail(String email, String newName);

    @Modifying
    @Transactional
    @Query(value = "update users\n" +
            "set password = :newPassword\n" +
            "where email = :email and password = :oldPassword",
            nativeQuery = true)
    void updatePasswordByEmailAndOldPassword(String email, String oldPassword, String newPassword);
}
