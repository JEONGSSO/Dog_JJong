package com.dogfriend.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class SbpWebSocketConfig implements WebSocketConfigurer{ //상속을 받아야한다

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //소켓 패스 정의를 여기다가 dogHome이 들어오면 내가처리한다
        registry.addHandler(new WebSocketHandler() , "/dogHome").setAllowedOrigins("*");    //도메인이 다를수도 있어서 써야한다.
    }
}