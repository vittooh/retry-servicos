package com.dbl.apisimples;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/numeros-retry")
public class IntegracaoNumerosController {


    private final NumeroRetryService numeroRetryService;

    public IntegracaoNumerosController(NumeroRetryService numeroRetryService) {
        this.numeroRetryService = numeroRetryService;
    }

    @GetMapping("/{num}")
    Long retornaNumerosComRetry(@PathVariable("num") Long num) throws Exception {
        return numeroRetryService.retornaNumero(num);
    }
}
