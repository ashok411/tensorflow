package com.example.tensorflow.controller;

import com.example.tensorflow.service.LlmService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LlmController {

    private LlmService llmService;

    public LlmController(LlmService llmService) {
        this.llmService = llmService;
    }

    @PostMapping("/generate-text")
    public String generateText(@RequestBody String prompt) {
        String generatedText = llmService.generateText(prompt);

        return generatedText;
    }
}