package com.example.springboot.services;

import com.example.springboot.model.Content;
import com.example.springboot.model.Part;
import com.example.springboot.dto.SessaoCompletaDTO;
import com.example.springboot.dto.respostas.RespostaDTO;
import com.example.springboot.dto.simulacao.ParametrosSimulacaoDTO;
import com.example.springboot.dto.GeminiRequest;
import com.example.springboot.model.GeminiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;


@Service

public class GeminiServices {

    private WebClient geminiWebClient;
    private final String model;

    public GeminiServices(WebClient geminiWebClient,
                          @Value("${excelencia.gem.model}") String model) {
        this.geminiWebClient = geminiWebClient;
        this.model = model;
    }
    // 1. Enviar prompt e retornar o Mono (fluxo reativo)
    // ⚠️ ALTERADO: Mudança de String para Mono<String> e remoção do .block()
    public Mono<String> enviarPrompt(String prompt) {

        return geminiWebClient.post()
                .uri("/models/{model}:generateContent", model) // ⬅️ ALTERADO: Usando o modelo injetado
                .bodyValue(buildGeminiRequest(prompt))
                .retrieve()
                .bodyToMono(GeminiResponse.class)
                .map(response -> {
                    // Extrai o texto real
                    if (response.getCandidates() != null && !response.getCandidates().isEmpty()) {
                        return response.getCandidates().get(0).getContent().getParts().get(0).getText();
                    }
                    return "Resposta não encontrada ou erro na API.";
                });
    }

    // ⚠️ ALTERADO: Substituído o objeto anônimo por um método de construção limpo
    private GeminiRequest buildGeminiRequest(String prompt) {
        // 🗑️ Removemos a variável Map<String, Object> config

        // Estrutura de conteúdo (sem alteração)
        List<Content> contents = List.of(
                new Content(List.of(new Part(prompt)))
        );


        return new GeminiRequest(contents);
    }

    // Métodos de avaliação e geração agora usam o novo enviarPrompt (Mono<String>)

    public Mono<String> avaliarResposta(RespostaDTO dto) {
        // ... (lógica de comando igual, mas retorno é Mono)
        String comando = """
                Avalie a resposta do candidato.
                
                Pergunta:
                %s
                
                Resposta:
                %s
                """.formatted(
                dto.getPergunta(),
                dto.getResposta()
        );
        return enviarPrompt(comando);
    }

    public Mono<String> gerarPergunta(ParametrosSimulacaoDTO dto) {
        // ... (lógica de comando igual, mas retorno é Mono)
        String comando = """
    Gere a próxima pergunta da entrevista.
    """;
        return enviarPrompt(comando);
    }

    public Mono<String> gerarRelatorio(SessaoCompletaDTO dto) {
        // ... (lógica de comando igual, mas retorno é Mono)
        String comando = """
    Gere o relatório final da entrevista.
    """;
        return enviarPrompt(comando);
    }
}