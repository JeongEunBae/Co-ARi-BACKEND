package com.cse.coari.domain.notices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticesRespository extends JpaRepository<Notices, Long> { // JpaRepository를 상속 시, 기본적으로 CRUD 기능 지원

    @Query(nativeQuery = true, value = "SELECT * FROM Notices ORDER BY date DESC")
    List<Notices> findAllDesc();
}