package com.example.springboot.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    // ESTE É O CAMPO CRUCIAL que causava o erro .content()
    private CandidateContent content;

    // Outros campos como 'finishReason' podem ser adicionados se necessários
}
