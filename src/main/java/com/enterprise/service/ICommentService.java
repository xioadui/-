package com.enterprise.service;

import com.enterprise.entity.Comment;

import java.util.List;

/**
 * 留言
 */
public interface ICommentService {
    String publishComment(Comment comment);
    List<Comment> searchCommentById(int id);
    String deleteCommentById(int id,String entId);
}
