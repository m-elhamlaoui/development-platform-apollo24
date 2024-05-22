package com.apollo.service;

import com.apollo.entities.LlamaResponse;

public interface LlamaAiService {
    LlamaResponse generateInfo(String topic);
}
