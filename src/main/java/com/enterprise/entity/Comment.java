package com.enterprise.entity;

/**
 * 留言
 */
public class Comment {
    //    留言ID
    private int commentId;
    //    发表留言的企业ID
    private String entId;
    //    发表留言的企业名称
    private String entName;
    //    评论的类型
    private int commentType;
    //    需求或者供应的ID
    private int id;
    //    留言日期
    private String commentDate;
    //    留言的内容
    private String commentContent;
    public String getEntName() { return entName; }
    public void setEntName(String entName) {
        this.entName = entName;
    }
    public int getCommentId() {
        return commentId;
    }
    public void setCommentId(int commentId) { this.commentId = commentId; }
    public String getEntId() {
        return entId;
    }
    public void setEntId(String entId) {
        this.entId = entId;
    }
    public int getCommentType() {
        return commentType;
    }
    public void setCommentType(int commentType) {
        this.commentType = commentType;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCommentDate() {
        return commentDate;
    }
    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }
    public String getCommentContent() {
        return commentContent;
    }
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
