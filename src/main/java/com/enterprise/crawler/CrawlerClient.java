package com.enterprise.crawler;

import com.enterprise.entity.Information;
import com.enterprise.service.serviceImpl.InformationServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/**
 *  定期执行爬取任务，并将数据保存到数据库中
 */
@Component
public class CrawlerClient {
    private static final Timer timer = new Timer();
    @Resource
    private InformationServiceImpl service;

    public String CrawlerClient() {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ICrawler crawler = new CrawlerImpl();
                List<Information> info = crawler.crawler(new ParseStrategy1("http://www.jyb.cn/list_gdjy/"));
                //将爬取的数据保存到数据库中
                try {
                    System.out.println("------------");
                    service.save(info);
                }catch (Exception e){
                    System.out.println(e);
                }
                //每隔30分钟爬取一次数据
            }
        }, 5000, 30*60*1000);
        return "success";
    }
}
