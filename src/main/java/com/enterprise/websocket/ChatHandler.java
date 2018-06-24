package com.enterprise.websocket;

import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;


/**
 *
 */
public class ChatHandler extends AbstractWebSocketHandler {
//    保存登录的用户
    private static ConcurrentHashMap<String,WebSocketSession> user = new ConcurrentHashMap<String,WebSocketSession>();
    @Override
    public void afterConnectionEstablished(WebSocketSession session){
        String userId = (String) session.getAttributes().get("userId");
        user.put(userId,session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
        String userId = (String) session.getAttributes().get("userId");
        user.remove(userId);
    }

//    当对方不在线的时候，发送一个提示信息
    private static final TextMessage canSendMessage = new TextMessage("对方不在线！！！");
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        JSONObject jsonObject = new JSONObject(message.getPayload());
        String toUser = jsonObject.getString("id2");
        try {
            WebSocketSession toUserSession = user.get(toUser);
            if(toUserSession==null){
                session.sendMessage(canSendMessage);
                return;
            }
            toUserSession.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
