package com.enterprise.service.crawler;

import com.enterprise.entity.Infomation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseStrategy1 extends AbstractParse {
    /**
     * @param url 爬取主页的URL
     */
    public ParseStrategy1(String url) {
        super(url);
    }
    @Override
    public List<Infomation> parse() {
        List<Infomation> listInfo = parseUrl(this.url);

        for(Infomation i:listInfo) {
            this.parseAPage(i.getUrl(), i);
        }
        return listInfo;
    }
    /**
     * @param url 主页的Url
     * @return 	包含要爬取页面的Url和摘要的Information List
     */
    private List<Infomation> parseUrl(String url){
        List<Infomation> infoList = new ArrayList<Infomation>();
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
            Elements yxj_lists = doc.getElementsByClass("yxj_list");
            Elements lis = yxj_lists.select("li");
            for(Element li:lis) {
                Infomation info = new Infomation();
                info.setDigest(li.select("div").toString());
                info.setUrl(li.select("a").attr("href"));
                infoList.add(info);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return infoList;
    }
    /**
     * @param pageUrl 一个页面的URL
     * @param info 代表资讯的Bean
     * @return
     */
    private Infomation parseAPage(String pageUrl,Infomation info) {
        Document doc = null;

        try {
            doc = Jsoup.connect(pageUrl).get();
            Elements xl_titles = doc.getElementsByClass("xl_title");
            Element xl_title = xl_titles.get(0);
//			获取头部的源码
            info.setHeader(xl_title.toString());
//			获得标题
            info.setTitle(xl_title.select("h1").text());
            //获得时间
            String time = xl_title.select("span").get(0).text();
            info.setDate(time.substring(time.indexOf("：")+1, time.length()));


//			修改源码中图片的URL
            Elements contentdiv = doc.getElementsByClass("contentdiv");
            Elements img = contentdiv.select("img");
            pageUrl = pageUrl.substring(0, pageUrl.lastIndexOf("/") + 1);
            for (int i = 0; i < img.size(); i++) {
                Element aImage = img.get(i);
                String src = aImage.attr("oldsrc");
                if(src!=null &&src.length()!=0) {
                    aImage.removeAttr("src");
                    aImage.attr("src", pageUrl + src);
                }
            }

            Elements xl_text = contentdiv.get(0).getElementsByClass("xl_text");
            Elements divs = xl_text.select("div");
//			不操作第一个标签
            for (int i = 1; i < divs.size(); i++) {
                Element div = divs.get(i);
                if (!div.hasAttr("style"))
//					在原来的基础上添加样式
                    div.attr("style", "margin-bottom: 14px;line-height: 25px;font-size: 14px;");
            }
            info.setContent(contentdiv.toString());

        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return info;
    }
}

