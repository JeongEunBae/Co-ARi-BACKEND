package com.cse.coari.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> { // JpaRepository를 상속 시, 기본적으로 CRUD 기능 지원

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE id = :userID")
    List<Users> findByUserID(@Param("userID") String userID);
}