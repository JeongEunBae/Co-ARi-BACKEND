package com.cse.coari.service.notices;

import com.cse.coari.domain.notices.Notices;
import com.cse.coari.domain.notices.NoticesRespository;
import com.cse.coari.web.dto.notices.NoticesListResponseDto;
import com.cse.coari.web.dto.notices.NoticesResponseDto;
import com.cse.coari.web.dto.notices.NoticesSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.ObjectUtils;

import javax.annotation.PostConstruct;
import javax.print.Doc;
import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;
import java.net.URL;
import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticesService {
    private final NoticesRespository noticesRespository;
    private static String CSE_NOTICE_URL = "https://cse.deu.ac.kr/bbs/board.php?bo_table=notice";

//    @PostConstruct
//    public void getNoticeData() throws IOException {
//        ArrayList<String> titles = new ArrayList<>();
//        ArrayList<String> urls = new ArrayList<>();
//        String[] authors = new String[0];
//        String[] datetimes = new String[0];
//
//        Document doc = Jsoup.connect(CSE_NOTICE_URL).get();
//        Elements contents = doc.select("tbody");
//
//        for(Element content : contents) {
//            Elements aContents = content.select("a");
//            for(Element aContent : aContents) {
//                titles.add(aContent.select("a").text());
//                urls.add(aContent.select("a").attr("href"));
//            }
//            authors = content.getElementsByClass("sv_member").text().split(" ");
//            datetimes = content.getElementsByClass("td_datetime").text().split(" ");
//        }
//
//        for(int index = 0; index < titles.size(); index++) {
////            saveDefaultData(authors[index], titles.get(index), urls.get(index), datetimes[index]);
//            NoticesSaveRequestDto requestDto = new NoticesSaveRequestDto(titles.get(index), authors[index], datetimes[index], urls.get(index));
//            save(requestDto);
//        }
//    }
//
////    public Long saveDefaultData(String author_data, String title_data, String url_data, String date_data) {
////        return noticesRespository.saveDefaultData(author_data, title_data, url_data, date_data);
////    }

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
    public List<NoticesListResponseDto> findAllDesc() { // 공지사항 전체 검색
        return noticesRespository.findAllDesc().stream()
                .map(NoticesListResponseDto::new)
                .collect(Collectors.toList());
    }
}
