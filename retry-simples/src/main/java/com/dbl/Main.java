package com.dbl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        executa(1L,1L);
    }


    public static void executa(Long numero, Long qtExecucao) {
        try {
            if (qtExecucao < 3) {
                String url = String.format("http://localhost:8080/v1/numeros/%s", numero);
                HttpRequest httpRequest = HttpRequest.newBuilder()
                        .uri(URI.create(url)).GET().build();

                HttpResponse<String> response = HttpClient.newHttpClient()
                        .send(httpRequest, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() != 200) {
                    throw new Exception("Não deu bom o processamento do numero");
                }
                System.out.println("Num retornado:: " + response.body());
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.out.println("indo chamar com chamada :" + (numero + 1) + " e exec " + (qtExecucao + 1));
            executa(numero+ 1,qtExecucao +1);
        }
    }
}