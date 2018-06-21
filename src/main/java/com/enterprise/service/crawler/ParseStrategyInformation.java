package com.enterprise.service.crawler;

import com.enterprise.entity.Information;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class ParseStrategyInformation extends AbstractParse{

    public ParseStrategyInformation(String url) {
        super(url);
    }

    @Override
    public List<?> parse() {
        Document doc = null;
        List<Information> list = new ArrayList<Information>();
        try {
            doc = Jsoup.connect(this.url).get();
//			获取所有行业资讯的种类
            Map<String,List<String>> urlMap =  getAllKinds(doc);
            Iterator<String> kind  = urlMap.keySet().iterator();
            while(kind.hasNext()) {
                String k = kind.next();
                Thread.sleep(1000);
                list.addAll(getAKindInformation(k,urlMap.get(k)));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 从主页中获取所有的种类以及该种类所对应的url
     * @param doc 要解析的网页内容
     * @return 每个种类和该种类中所有的URL
     */
    private Map<String,List<String>> getAllKinds(Document doc){
        Map<String,List<String>> result = new HashMap<String,List<String>>();
        Elements contents = doc.getElementsByClass("w750 mb10");
        String text=null;
        List<String> temp = new ArrayList<String>();
//		获取所有的行业种类
        for(Element content:contents) {
            Elements h3s = content.select("h3");
            for(Element h3:h3s) {
                text = h3.select("a").text();
                temp.add(text);
            }
        }
        int i=0;
        Elements urls = contents;
//		获取某个行业种类所有对应的URL
        for(Element url:urls) {
            Elements lis = url.getElementsByClass("ul12");
            for(Element li:lis) {
                List<String> urlList = new ArrayList<String>();
                Elements hrefs = li.select("a");
                for(Element href:hrefs) {
                    urlList.add(href.attr("href"));
                }
                result.put(temp.get(i++), urlList);
            }
        }
        return result;
    }
    /**
     * 解析每一个详细的文章
     * kind  资讯的种类
     * urls	该种类资讯详细页面的url
     * 返回
     */
    private List<Information> getAKindInformation(String kind,List<String> urls){
        Document doc = null;
        List<Information> informationList = new ArrayList<Information>();
        for (String url : urls) {
            Information info = new Information();
            Elements content = null;
            try {
                doc = Jsoup.connect(url).get();
                content = doc.getElementsByClass("bgray neirong");
//				获取标题
            } catch (Exception e) {
                e.printStackTrace();
            }
            info.setTitle(content.select("h1").text());
//				获取时间
            info.setDate(content.select(".pubTime").text().split(" ")[0].trim());
            String digest = content.select(".arcdec").text();
//				摘要
            info.setDigest(digest.substring(digest.indexOf("：")+1));
//				内容
            info.setContent(content.select(".arccon").toString());
//				所属行业
            info.setType(kind);
            info.setId(System.currentTimeMillis());
            informationList.add(info);
        }
        return informationList;
    }
}

