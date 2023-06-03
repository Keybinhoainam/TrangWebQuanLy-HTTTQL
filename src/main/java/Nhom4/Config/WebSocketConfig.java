package Nhom4.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import Nhom4.Handler.WebSocketHandlers;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(myHandler(), "/myhandler");
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new WebSocketHandlers();
    }

}
/*
 * @Configuration
 * 
 * @EnableWebSocketMessageBroker public class WebSocketConfig implements
 * WebSocketMessageBrokerConfigurer {
 * 
 * @Override public void registerStompEndpoints(StompEndpointRegistry registry)
 * { registry.addEndpoint("/live-temperature").withSockJS(); }
 * 
 * @Override public void configureMessageBroker(MessageBrokerRegistry registry)
 * { registry.enableSimpleBroker("/topic"); }
 * 
 * 
 * 
 * }
 */