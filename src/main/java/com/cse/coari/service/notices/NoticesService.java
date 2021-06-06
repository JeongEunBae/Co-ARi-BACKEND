package com.cse.coari.service.notices;

import com.cse.coari.crawler.NewsCrawler;
import com.cse.coari.crawler.NoticesCrawler;
import com.cse.coari.domain.notices.Notices;
import com.cse.coari.domain.notices.NoticesRespository;
import com.cse.coari.web.dto.notices.NoticesListResponseDto;
import com.cse.coari.web.dto.notices.NoticesResponseDto;
import com.cse.coari.web.dto.notices.NoticesSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticesService {
    @Autowired
    private NoticesRespository noticesRespository;

    public Long save(NoticesSaveRequestDto requestDto) {
        // 공지사항 등록
        return noticesRespository.save(requestDto.toEntity()).getNotice_id();
    }

    public NoticesResponseDto findById(Long notice_id) { // 해당 공지사항 검색
        Notices entity = noticesRespository.findById(notice_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 공지사항이 없습니다. id=" + notice_id));

        return new NoticesResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<NoticesListResponseDto> findAll() throws IOException { // 공지사항 전체 검색
        return noticesRespository.findAll().stream()
                .map(NoticesListResponseDto::new)
                .collect(Collectors.toList());

    }

    public void noticeCrawler() throws IOException { // 학과 공지사항 크롤링
        NoticesCrawler noticesCrawler = new NoticesCrawler();
        noticesCrawler.crawlingNoticeData();

        List<Notices> noticesList = new ArrayList<>();
        for(int index = 0; index < noticesCrawler.getTitles().size(); index++) {
            NoticesSaveRequestDto requestDto = new NoticesSaveRequestDto(noticesCrawler.getTitles().get(index),
                    noticesCrawler.getAuthors()[index], noticesCrawler.getDatetimes()[index], noticesCrawler.getUrls().get(index));

            noticesList.add(requestDto.toEntity());
        }
        noticesRespository.saveAll(noticesList);
    }
}
