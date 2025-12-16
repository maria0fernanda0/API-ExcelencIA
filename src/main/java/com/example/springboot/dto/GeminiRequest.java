package com.example.springboot.dto;

import com.example.springboot.model.Content;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GeminiRequest {
    private List<Content> contents;
    private Map<String, Object> config;

    // Construtor manual (que você usa no buildGeminiRequest)
    public GeminiRequest(List<Content> contents) {
        this.contents = contents;
    }

    // Getters e Setters (Jackson precisa do Getter para serializar!)
    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    // Você também precisaria de um construtor vazio se fosse desserializar (o que não é o caso aqui),

}
