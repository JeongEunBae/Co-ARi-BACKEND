package com.cse.coari.domain.anchors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnchorsRepository extends JpaRepository<Anchors, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM anchors")
    List<Anchors> findAll();

}
