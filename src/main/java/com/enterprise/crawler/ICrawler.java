package com.enterprise.crawler;

import com.enterprise.entity.Information;

import java.util.List;

public interface ICrawler {
    public List<Information> crawler(AbstractParse parseStragy);
}
