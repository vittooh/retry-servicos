package com.dbl.apisimples;

import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NumeroRetryService {
    private final RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(NumeroRetryService.class);

    public NumeroRetryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Retryable(retryFor = Exception.class,maxAttempts = 1,
            backoff = @Backoff(delay = 3000),recover = "recuperaFalhaNumero")
   public Long retornaNumero(Long num) throws Exception {
        String url = "http://localhost:8080/v1/numeros/" + num;
        ResponseEntity<Long> response = restTemplate.getForEntity(url, Long.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new Exception("Não consegui recuperar o numero");
        }
        return response.getBody();
    }

    @Recover
    public Long recuperaFalhaNumero(Exception e,Long num){
        logger.error(e.getMessage());
        logger.error("Numero recebido :: " + num);
        return -1L;
    }
}
