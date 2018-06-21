package com.enterprise.entity;

/**
 * @author 陈康勇
 *	行业资讯
 */
public class Information {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;
    //	资讯的类型
    private String type;
    //	资讯的标题
    private String title;
    //	时间
    private String date;
    //	资讯内容，源码
    private String content;
    //	摘要，源码
    private String digest;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getDigest() {
        return digest;
    }
    public void setDigest(String digest) {
        this.digest = digest;
    }

}

