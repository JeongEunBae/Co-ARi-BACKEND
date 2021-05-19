package com.cse.coari.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> { // JpaRepository를 상속 시, 기본적으로 CRUD 기능 지원
}
