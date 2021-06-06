package com.cse.coari.crawler;

import com.cse.coari.service.notices.NoticesService;
import com.cse.coari.web.dto.notices.NoticesSaveRequestDto;
import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

@Getter
public class NoticesCrawler {
    private static String CSE_NOTICE_URL = "https://cse.deu.ac.kr/bbs/board.php?bo_table=notice";

    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<String> urls = new ArrayList<>();
    private String[] authors = new String[0];
    private String[] datetimes = new String[0];

    public void crawlingNoticeData() throws IOException {
        Document doc = Jsoup.connect(CSE_NOTICE_URL).get();
        Elements contents = doc.select("tbody");

        for(Element content : contents) {
            Elements aContents = content.select("a");
            for(Element aContent : aContents) {
                titles.add(aContent.select("a").text());
                urls.add(aContent.select("a").attr("href"));
            }
            authors = content.getElementsByClass("sv_member").text().split(" ");
            datetimes = content.getElementsByClass("td_datetime").text().split(" ");
        }
    }
}
