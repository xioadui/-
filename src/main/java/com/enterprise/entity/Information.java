package com.enterprise.entity;

public class Information {
    //	资讯的标题
    private String title;
    //	发布时间
    private String date;
    //	资讯的头部，源码
    private String header;
    //	资讯内容，源码
    private String content;
    //	摘要，源码
    private String digest;
    //	页面的url，这个可不存数据库
    private String url;
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getHeader() {
        return header;
    }
    public void setHeader(String header) {
        this.header = header;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getDigest() {
        return digest;
    }
    public void setDigest(String digest) {
        this.digest = digest;
    }
}
