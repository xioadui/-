package com.enterprise.controller;

import com.enterprise.entity.Comment;
import com.enterprise.service.serviceImpl.CommentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 留言控制器，用户获取需求和供应对应的留言
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentController {
    @Resource
    private CommentServiceImpl commentService;
    @RequestMapping(value = "/searchCommentById")
    @ResponseBody
    public Map<String,Object> searchProvideById(@RequestParam("id") String id){
        List<Comment> commentList = commentService.searchCommentById(Integer.parseInt(id));
        Map<String,Object> resultMap = new HashMap<>();
        List<Object> list = new ArrayList<>();
        for(Comment c:commentList){
            Map<String,Object> commentMap = new HashMap<>();
            commentMap.put("entId",c.getEntId());
            commentMap.put("commentContent",c.getCommentContent());
            commentMap.put("commentId",c.getCommentId());
            commentMap.put("commentType", c.getCommentType());
            commentMap.put("entName",c.getEntName());
            commentMap.put("id", c.getId());
            commentMap.put("commentDate",c.getCommentDate());
            list.add(commentMap);
        }
        resultMap.put("result",list);
        return resultMap;
    }

    @RequestMapping(value = "/deleteProvideById")
    @ResponseBody
    public String deleteProvideById(int id, HttpSession session){
        String entId = (String)session.getAttribute("entId");
        return commentService.deleteCommentById(id,entId);
    }

    @RequestMapping(value = "/publishComment")
    @ResponseBody
    public String publishComment(String id,String entId,String commentDate,String commentContent){
        Comment comment = new Comment();
        comment.setEntId(entId);
        comment.setId(Integer.parseInt(id));
        comment.setCommentType(1);
        comment.setCommentDate(commentDate);
        comment.setCommentContent(commentContent);
        commentService.publishComment(comment);
        return "success";
    }


}
