package com.example.springboot.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateContent {
    // Note que é uma lista, pois o modelo pode retornar conteúdo multi-parte
    private List<TextPart> parts;
}