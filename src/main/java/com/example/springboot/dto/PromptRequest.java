package com.example.springboot.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude; // ⬅️ NOVO IMPORT

// ⬇️ Adicione esta anotação na parte superior das três classes (GeminiRequest, Content, Part)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromptRequest {
    private String pergunta; // ⬅️ O campo deve se chamar "pergunta"
}