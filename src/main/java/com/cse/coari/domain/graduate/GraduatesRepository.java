package com.cse.coari.domain.graduate;

import com.cse.coari.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GraduatesRepository extends JpaRepository<Graduates, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM graduates ORDER BY graduate_id")
    List<Graduates> findAll();

}
