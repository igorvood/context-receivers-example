package ru.vood.context.receivers.example.contextreceiversexample.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {

    @Bean
    fun webClient(): WebClient {
        return WebClient.builder()
            .baseUrl("http://localhost:8080") // базовый URL
            .defaultHeader("Accept", "application/json")
            .defaultHeader("Content-Type", "application/json")
            .build()
    }
}