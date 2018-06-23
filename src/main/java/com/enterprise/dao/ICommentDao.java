package com.enterprise.dao;

import com.enterprise.entity.Comment;

import java.util.List;

public interface ICommentDao {
    String publishComment(Comment comment);
    List<Comment> searchCommentById(int id);
    String deleteCommentById(int id,String entId);
}
