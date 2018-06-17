package com.enterprise.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(chatMessageHandler(),"/message").setAllowedOrigins("*").addInterceptors(chatHandlerShake());
    }
    @Bean
    public AbstractWebSocketHandler chatMessageHandler(){
        return new ChatHandler();
    }
    @Bean
    public HandshakeInterceptor chatHandlerShake(){
        return new ChatHandlerShake();
    }
}
