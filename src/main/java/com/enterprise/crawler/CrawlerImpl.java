package com.enterprise.crawler;

import com.enterprise.entity.Information;

import java.util.List;

public class CrawlerImpl implements ICrawler{
    @Override
    public List<Information> crawler(AbstractParse parseStragy) {

        return parseStragy.parse();
    }
}