package com.dogfriend.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {

    Map<String, WebSocketSession> map = new HashMap<>();
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        System.out.println("afterConnectionEstablished" + session);
    };
    
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
        System.out.println("handleTextMessage : " + session + " : " + message);
    };
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
        // System.out.println("afterConnectionClosed : " + session + " : " + status);
    };
}