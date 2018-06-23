package com.enterprise.service.serviceImpl;

import com.enterprise.dao.ICommentDao;
import com.enterprise.entity.Comment;
import com.enterprise.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 留言
 */
@Service
public class CommentServiceImpl implements ICommentService {
    @Resource
    private ICommentDao commentDao;
    @Override
    public String publishComment(Comment comment) {
        return commentDao.publishComment(comment);
    }
    @Override
    public List<Comment> searchCommentById(int id) {
        return commentDao.searchCommentById(id);
    }

    @Override
    public String deleteCommentById(int id,String entId) {
        return commentDao.deleteCommentById(id, entId);
    }
}
