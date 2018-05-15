package com.enterprise.service.crawler;

import com.enterprise.entity.Infomation;

import java.util.List;

public interface ICrawler {
    public List<Infomation> crawler(AbstractParse parseStragy);
}
