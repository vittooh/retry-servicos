package com.dbl.apisimples;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/numeros")
public class NumerosController {


    @GetMapping("/{numero}")
    Long retornaNumero(@PathVariable("numero") Long numero) throws Exception {
        if (numero % 2 ==0){
            return 42L;
        }else{
            throw new Exception("Não atendo numeros impares");
        }
    }
}
