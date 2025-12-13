package com.example.springboot.controller;


import com.example.springboot.dto.SessaoCompletaDTO;
import com.example.springboot.dto.respostas.RespostaDTO;
import com.example.springboot.dto.simulacao.ParametrosSimulacaoDTO;
import com.example.springboot.services.GeminiServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gem")
@RequiredArgsConstructor

public class GeminiController {

    private final GeminiServices geminiService;

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
    @PostMapping("/pergunta")
    public String gerarPergunta(@RequestParam ParametrosSimulacaoDTO dto) {
        return geminiService.gerarPergunta(dto);
    }

    // 4. Gerar relatório
    @PostMapping("/relatorio")
    public String gerarRelatorio(@RequestBody SessaoCompletaDTO dto) {
        return geminiService.gerarRelatorio(dto);
    }
}
