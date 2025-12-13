package com.example.springboot.controller;

import com.example.springboot.model.Feedbacks;
import com.example.springboot.repository.FeedbacksRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedbacks")
@CrossOrigin("*")

public class FeedbacksController {

    private final FeedbacksRepository feedbacksRepository;

    public FeedbacksController(FeedbacksRepository feedbacksRepository) {
        this.feedbacksRepository = feedbacksRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedbacks> buscar(@PathVariable Long id) {
        return feedbacksRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Feedbacks> criar(@RequestBody Feedbacks feedback) {
        return ResponseEntity.ok(feedbacksRepository.save(feedback));
    }
}
