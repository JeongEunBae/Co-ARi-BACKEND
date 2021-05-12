package com.cse.coari.domain.alarms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmsRepository extends JpaRepository<Alarms, Long> {// JpaRepository를 상속 시, 기본적으로 CRUD 기능 지원
}
