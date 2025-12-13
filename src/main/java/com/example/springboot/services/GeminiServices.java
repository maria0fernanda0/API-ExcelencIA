package com.example.springboot.services;


import com.example.springboot.dto.SessaoCompletaDTO;
import com.example.springboot.dto.respostas.RespostaDTO;
import com.example.springboot.dto.respostas.RespostaRequestDTO;
import com.example.springboot.dto.simulacao.ParametrosSimulacaoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GeminiServices {

    private final WebClient geminiWebClient;

    // 1. Enviar prompt simples
    public String enviarPrompt(String prompt) {

        return geminiWebClient.post()
                .uri("/models/gemini-1.5-flash:generateContent")
                .bodyValue(buildRequest(prompt))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    // Exemplo simples de corpo da requisição
    private Object buildRequest(String prompt) {
        return new Object() {
            public final Object[] contents = {
                    new Object() {
                        public final Object[] parts = {
                                new Object() {
                                    public final String text = prompt;
                                }
                        };
                    }
            };
        };
    }

    public String avaliarResposta(RespostaDTO dto) {

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

    public String gerarPergunta(ParametrosSimulacaoDTO dto) {

        String comando = """
    Gere a próxima pergunta da entrevista.
    """;

        return enviarPrompt(comando);
    }

    public String gerarRelatorio(SessaoCompletaDTO dto) {

        String comando = """
    Gere o relatório final da entrevista.
    """;

        return enviarPrompt(comando);
    }

}
