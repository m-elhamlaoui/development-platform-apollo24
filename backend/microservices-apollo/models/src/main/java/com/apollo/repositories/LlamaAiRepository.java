package com.apollo.repositories;

import com.apollo.entities.LlamaResponse;
import com.apollo.service.LlamaAiService;
import org.springframework.ai.chat.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LlamaAiRepository implements LlamaAiService {
    private final ChatClient chatClient;

    @Autowired
    public LlamaAiRepository(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public LlamaResponse generateInfo(String topic) {
        final String llamaMessage = chatClient.call(String.format("Tell some information about %s", topic));
        LlamaResponse llamaResponse = new LlamaResponse();
        llamaResponse.setMessage(llamaMessage);
        return llamaResponse;
    }
}
