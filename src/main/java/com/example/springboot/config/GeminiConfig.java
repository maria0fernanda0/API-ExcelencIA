package com.example.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import org.springframework.web.reactive.function.client.ExchangeFilterFunction; // ⬅️ Essencial para o filtro
import reactor.core.publisher.Mono;

@Configuration
public class GeminiConfig {

    @Value("${excelencia.gem.base-url}")
    private String baseUrl;

    @Value("${excelencia.gem.api.key}")
    private String apiKey;

    @Value("${excelencia.gem.model}")
    private String model;

    @Bean
    public WebClient geminiWebClient() {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("x-goog-api-key", apiKey)
                .filter(logRequest())
                .build();
    }

    // ⬇️ NOVO MÉTODO: Filtro para logar a requisição e a resposta
    private ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(request -> {
            System.out.println("Enviando requisição...");
            request.headers().forEach((name, values) -> {
                if (!name.equals("x-goog-api-key")) { // Evitar logar a chave
                    System.out.printf("   Header %s: %s%n", name, values);
                }
            });
            // O corpo é difícil de logar totalmente aqui, mas os headers já ajudam
            return Mono.just(request);
        });
    }
}
