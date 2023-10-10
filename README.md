Projeto simples para exemplificar o uso de retry.


O módulo retry-simples chama a api contida dentro de api-simples no caminho "/v1/numeros/{num}" 
e em caso de falha o mesmo está dentro de um bloco try catch configurado para chamar a mesma função de forma recursiva
até um limite de 3 chamadas em caso de erro ou até a chamada retornar com sucesso.


O módulo api-simples contém 2 apis 

"/v1/numeros/{num}"  que é intermitente e retorna sucesso para números pares e erro para numeros impares

"/v1/retry-numeros/{num}" que é uma implementação de retry usando a lib spring-retry chamando a api ""/v1/numeros/{num}" e tratando o erro
e fazendo retentando as chamadas em caso de falha até o numero máximo estabelicido. 