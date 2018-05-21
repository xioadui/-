package com.enterprise.service.crawler;

import com.enterprise.entity.Information;

import java.util.List;

public class CrawlerImpl<T> implements ICrawler<T>{
    @SuppressWarnings("unchecked")
    @Override
    public List<T> crawler(AbstractParse parseStragy) {

        return (List<T>) parseStragy.parse();
    }
}