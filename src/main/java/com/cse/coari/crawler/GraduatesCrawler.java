package com.cse.coari.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class GraduatesCrawler {
    private static String CSE_GRADUATES_URL = "https://cse.deu.ac.kr/6_1_job.php";

    private ArrayList<String> graduateNames = new ArrayList<>();
    private ArrayList<String> imageUrls = new ArrayList<>();

    public void crawlingGraduateDataList() throws IOException {
        Document doc = Jsoup.connect(CSE_GRADUATES_URL).get();
        Elements contents = doc.getElementsByClass("flip-card");

        for(Element content : contents) {
            graduateNames.add(content.select("p").text());
            imageUrls.add(content.getElementsByClass("hbutton").select("img").attr("src"));

            System.out.println("이름 : " + content.select("p").text());
            System.out.println("이미지 링크 : + " + content.getElementsByClass("hbutton").select("img").attr("src"));
        }
    }
}
