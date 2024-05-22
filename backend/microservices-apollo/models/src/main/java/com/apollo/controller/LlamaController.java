package com.apollo.controller;

import com.apollo.service.LlamaAiService;
import com.apollo.entities.LlamaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LlamaController {
    private final LlamaAiService llamaAiService;

    @Autowired
    public LlamaController(LlamaAiService llamaAiService) {
        this.llamaAiService = llamaAiService;
    }

    @GetMapping("api/v1/ai/generate/info/{topic}")
    public ResponseEntity<LlamaResponse> generateJoke(@PathVariable String topic) {
        final LlamaResponse aiResponse = llamaAiService.generateInfo(topic);
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse);
    }
}
