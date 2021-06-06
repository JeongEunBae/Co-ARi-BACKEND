package com.cse.coari.crawler;

import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

@Getter
public class NewsCrawler {
    private static String CSE_NEWS_URL = "https://cse.deu.ac.kr/bbs/board.php?bo_table=gallery";

    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<String> urls = new ArrayList<>();
    private ArrayList<String> authors = new ArrayList<>();
    private ArrayList<String> dates = new ArrayList<>();
    private ArrayList<String> news_thumbnails = new ArrayList<>();

    public void crawlingNewsData() throws IOException {
        Document doc = Jsoup.connect(CSE_NEWS_URL).get();
        Elements contents = doc.getElementsByClass("gall_con");

        for(Element content : contents) {
            titles.add(content.getElementsByClass("gall_text_href").text());
            urls.add(content.getElementsByClass("gall_text_href").select("a").attr("href"));
            authors.add(content.getElementsByClass("sv_member").text());
            dates.add(content.getElementsByClass("gall_if").text().split(" ")[2]);
            news_thumbnails.add(content.getElementsByClass("gall_href").select("img").attr("src"));
        }
    }

}
