package com.enterprise.service.crawler;

import com.enterprise.entity.Infomation;

import java.util.List;

public abstract class AbstractParse {
    protected String url;
    public AbstractParse(String url) {
        this.url = url;
    }
    public abstract List<Infomation> parse();
}