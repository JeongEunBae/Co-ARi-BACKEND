package com.cse.coari.domain.notices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticesRespository extends JpaRepository<Notices, Long> { // JpaRepository를 상속 시, 기본적으로 CRUD 기능 지원

    @Query(nativeQuery = true, value = "SELECT * FROM notices ORDER BY date DESC")
    List<Notices> findAllDesc();

//    @Query(nativeQuery = true, value = "INSERT INTO notices(author, title, url, date) VAULES(#{authorD}, #{titleD}, #{urlD}, #{dateD})")
//    Long saveDefaultData(@Param("authorD") String author_data, @Param("titleD") String title_data, @Param("urlD") String url_data, @Param("dateD") String date_data);

}
