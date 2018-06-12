package com.enterprise.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;


public class ChatHandler extends AbstractWebSocketHandler {
//    保存登录的用户
    private static ConcurrentHashMap<String,WebSocketSession> user = new ConcurrentHashMap<String,WebSocketSession>();
    static int i=0;
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //String userId = (String) session.getAttributes().get("userId");
        user.put(""+i++,session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String userId = (String) session.getAttributes().get("userId");
        user.remove(""+i);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        try {
//            session.getAttributes();
            System.out.println(message.getPayload());
            for(WebSocketSession s:user.values()){
                s.sendMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
