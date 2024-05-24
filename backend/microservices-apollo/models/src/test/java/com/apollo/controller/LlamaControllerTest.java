package com.apollo.controller;

import com.apollo.entities.LlamaResponse;
import com.apollo.service.LlamaAiService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class LlamaControllerTest {

    @Test
    public void testGenerateJoke(){

        LlamaAiService llamaAiService = Mockito.mock(LlamaAiService.class);

        String topic = "testTopic";
        String expectedMessage = "This is a test message";
        LlamaResponse expectedResponse = new LlamaResponse();
        expectedResponse.setMessage(expectedMessage);
        Mockito.when(llamaAiService.generateInfo(topic)).thenReturn(expectedResponse);

        LlamaController controller = new LlamaController(llamaAiService);

        ResponseEntity<LlamaResponse> responseEntity = controller.generateJoke(topic);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(responseEntity.getBody().getMessage()).isEqualTo(expectedMessage);

    }

}