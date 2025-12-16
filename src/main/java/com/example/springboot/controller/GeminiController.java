package com.example.springboot.controller;

import com.example.springboot.dto.SessaoCompletaDTO;
import com.example.springboot.dto.pergunta.PerguntaDTO;
import com.example.springboot.dto.PromptRequest;
import com.example.springboot.dto.respostas.RespostaDTO;
import com.example.springboot.dto.simulacao.ParametrosSimulacaoDTO;
import com.example.springboot.services.GeminiServices;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping(value ="/gem", produces = MediaType.APPLICATION_JSON_VALUE)
public class GeminiController {

    private final GeminiServices geminiService;

    public GeminiController(GeminiServices geminiService) {
        this.geminiService = geminiService;
    }


    @PostMapping("/ask")
    // ⬇️ CORREÇÃO: Recebe o objeto PromptRequest
    public Mono<String> askGemini(@RequestBody PromptRequest request) {
        // ⬇️ CORREÇÃO: Passa o campo 'pergunta' para o serviço
        return geminiService.enviarPrompt(request.getPergunta());
    }

    // 2. Avaliar resposta
    @PostMapping("/avaliar")
    public String avaliarResposta(@RequestBody RespostaDTO dto) {
        // ⬅️ ALTERADO: Adicionado .block()
        return geminiService.avaliarResposta(dto).block();
    }

    // 3. Gerar nova pergunta
    @PostMapping(value = "/pergunta")
    public ResponseEntity<String> perguntar(@RequestBody ParametrosSimulacaoDTO dto) { // ⬅️ ALTERADO: Mudei o DTO
        // ⬅️ ALTERADO: Usando o serviço Gemini para gerar a pergunta
        String perguntaGerada = geminiService.gerarPergunta(dto).block();
        return ResponseEntity.ok(perguntaGerada);
    }

    // 4. Gerar relatório
    @PostMapping("/relatorio")
    public String gerarRelatorio(@RequestBody SessaoCompletaDTO dto) {
        // ⬅️ ALTERADO: Adicionado .block()
        return geminiService.gerarRelatorio(dto).block();
    }
}