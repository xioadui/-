package com.enterprise.service.crawler;

import com.enterprise.entity.IndustryData;
import com.enterprise.entity.Information;
import com.enterprise.service.serviceImpl.IndustryDataServiceImpl;
import com.enterprise.service.serviceImpl.InformationServiceImpl;
import org.springframework.stereotype.Component;

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
    private InformationServiceImpl informationService;

    @Resource
    private IndustryDataServiceImpl industryDataS;
    public CrawlerClient() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //爬取资讯
                ICrawler<Information> crawlerInformation = new CrawlerImpl<Information>();
                List<Information> informationList = crawlerInformation.crawler(new ParseStrategyInformation("http://www.chinabgao.com/info/?from=groupmessage"));
                try {
                    informationService.save(informationList);
                }catch (Exception e){
                }
//				//爬行业数据
                ICrawler<IndustryData> crawlerData = new CrawlerImpl<IndustryData>();
                List<IndustryData> dataList = crawlerData.crawler(new ParseStrategyIndustryData("http://www.chinabgao.com/stat/industry.html"));
                try {
                    industryDataS.save(dataList);
                }catch (Exception e){
                }

//                每隔30分钟爬取一次数据
            }
        }, 1000*60*30, 30*60*1000);
    }
}
