package com.enterprise.service.crawler;

import com.enterprise.entity.IndustryData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.*;

public class ParseStrategyIndustryData extends AbstractParse {

    private static List<String> type=new ArrayList<String>();
    //	网站的根路径
    private String rootUrl = super.url.substring(0, super.url.indexOf("com")+3);
    //	添加要爬取数据的行业
    static {
        type.add("IT与通讯");type.add("机械电子");type.add("医疗医药保健");type.add("金融保险投资");
        type.add("车辆交通");type.add("能源矿产");type.add("建材房产");type.add("家用电器");
    }
    public ParseStrategyIndustryData(String url) {
        super(url);
    }
    /*
     * 开始爬取数据
     */
    @Override
    public List<?> parse() {
//		用于保存最终的结果
        List<IndustryData> dataList = new ArrayList<IndustryData>();
//		从主页中获取想要的行业
        Map<String,String> dustyMap = getMainPage();
        List<IndustryData> tempList = null;
        Iterator<String> it = dustyMap.keySet().iterator();
        while(it.hasNext()) {
            String type = it.next();
//			获取该行业对应的主页URL
            String url = dustyMap.get(type);
//			利用该主页的URL来获取该主页下所有的行业数据对应的URL
            List<String> uList = getTypeAllUrl(url);
//			用给出的URL来获取详细的信息
            tempList = getIndustryData(uList,type);
//			将数据添加到最终的容器中
            dataList.addAll(tempList);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return dataList;
    }
    /**
     * 从主页中获取要爬取行业的
     */
    private Map<String,String> getMainPage() {
//		记录行业和所对应的链接
        Map<String,String> dustyMap = new HashMap<String,String>();
        Document doc;
        try {
            doc = Jsoup.connect(super.url).get();
            Elements types = doc.getElementsByClass("sstatnav");
            Elements as = types.select("a");
            for(Element a : as) {
//				当检索的这个是目标的行业时，记录这个链接
                if(type.contains(a.text())) {
                    dustyMap.put(a.text(), rootUrl+a.attr("href"));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return dustyMap;
    }

    /**
     * 获取某个行业所对应的所有的URL
     * @return
     */
    private List<String> getTypeAllUrl(String url) {
        List<String> list = new ArrayList<String>();
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
            Elements listuls = doc.getElementsByClass("listul ul14");
            Elements lis = listuls.select("li");

            for(Element li:lis) {
                list.add(li.select("a").attr("href"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * @param urls 该行业所有页面的URL
     * @return 每个URL所对应页面的详细信息
     */
    private List<IndustryData> getIndustryData(List<String> urls,String type){
        List<IndustryData> industryList = new ArrayList<IndustryData>();
        Document doc = null;
        for (String url : urls) {
            IndustryData data = new IndustryData();
            try {
                doc = Jsoup.connect(url).get();
                Elements content = doc.getElementsByClass("bgray neirong");
//				获取标题
                data.setTitle(content.select("h1").text());
//				获取时间
                String time = content.select(".pubTime").text();
                if(time.contains("年")){
                    time = time.split("日")[0].replaceAll("[年|月|日]", "-");
                }else{
                    time = time.split(" ")[0];
                }
                data.setDate(time);
                String digest = content.select(".arcdec").text();
                Elements p = content.select(".arccon").select("p");
//				摘要
                data.setDigest(p.first().toString());
                data.setId(System.currentTimeMillis());
//				内容
                data.setContent(content.select(".arccon").toString());
//				所属行业
                data.setType(type);
                industryList.add(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return industryList;
    }
}

