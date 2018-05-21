package com.enterprise.service.crawler;

import com.enterprise.entity.Information;

import java.util.List;

public interface ICrawler<T> {
    public List<T> crawler(AbstractParse parseStragy);
}

