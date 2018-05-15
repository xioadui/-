package com.enterprise.service.crawler;

import com.enterprise.entity.Infomation;

import java.util.List;

public class CrawlerImpl implements ICrawler{
    @Override
    public List<Infomation> crawler(AbstractParse parseStragy) {

        return parseStragy.parse();
    }
}