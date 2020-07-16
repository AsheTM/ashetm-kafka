package com.ashetm.project.kafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Value("${custom.websocket.endpoint}")
    private String webSocketEndpoint;

    @Value("${custom.websocket.prefix}")
    private String webSocketPrefix;

    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(this.webSocketEndpoint).withSockJS();
    }

    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker(this.webSocketPrefix);
    }

}
