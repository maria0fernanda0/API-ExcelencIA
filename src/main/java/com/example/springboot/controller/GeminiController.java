package com.example.springboot.controller;


import com.example.springboot.dto.SessaoCompletaDTO;
import com.example.springboot.dto.pergunta.PerguntaDTO;
import com.example.springboot.dto.respostas.RespostaDTO;
import com.example.springboot.dto.simulacao.ParametrosSimulacaoDTO;
import com.example.springboot.services.GeminiServices;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value ="/gem",
        produces = MediaType.APPLICATION_JSON_VALUE
)


public class GeminiController {

    private final GeminiServices geminiService;

    public GeminiController(GeminiServices geminiService) {
        this.geminiService = geminiService;
    }




    // 1. Teste simples
    @PostMapping("/ask")
    public String enviarPrompt(@RequestBody String mensagem) {
        return geminiService.enviarPrompt(mensagem);
    }

    // 2. Avaliar resposta
    @PostMapping("/avaliar")
    public String avaliarResposta(@RequestBody RespostaDTO dto) {
        return geminiService.avaliarResposta(dto);
    }

    // 3. Gerar nova pergunta
    @PostMapping(
            value = "/pergunta"
    )
    public ResponseEntity<String> perguntar(@RequestBody PerguntaDTO dto) {
        return ResponseEntity.ok("Pergunta recebida: " + dto.getPergunta());
    }

    // 4. Gerar relatório
    @PostMapping("/relatorio")
    public String gerarRelatorio(@RequestBody SessaoCompletaDTO dto) {
        return geminiService.gerarRelatorio(dto);
    }



}
