package com.cse.coari.domain.graduate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GraduatesRepository extends JpaRepository<Graduates, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM graduates ORDER BY graduate_id")
    List<Graduates> findAll();
}
