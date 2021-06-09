package com.cse.coari.domain.alarms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlarmsRepository extends JpaRepository<Alarms, Long> {// JpaRepository를 상속 시, 기본적으로 CRUD 기능 지원

    @Query(nativeQuery = true, value = "SELECT * FROM alarms ORDER BY send_time DESC")
    List<Alarms> findAllDesc();

    @Query(nativeQuery = true, value = "SELECT * FROM alarms ORDER BY send_time DESC LIMIT 1")
    Alarms findDescRecent();
}
