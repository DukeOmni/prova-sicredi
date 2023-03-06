# Prova técnica Compass 

O projeto faz parte do esforço para demonstrar o nível técnico ao intrevistador Sicredi

## Cenário de Negócio
No cooperativismo, cada associado possui um voto e as decisões são tomadas em assembleias,
por votação. Imagine que você deve criar uma solução para dispositivos móveis para gerenciar e
participar dessas sessões de votação.
Essa solução deve ser executada na nuvem e promover as seguintes funcionalidades através de
uma API REST
Para fins de exercício, a segurança das interfaces pode ser abstraída e qualquer chamada para as interfaces pode ser considerada como autorizada. A solução deve ser construída em java, usando Spring-boot, mas os frameworks e bibliotecas são de livre escolha (desde que não infrinja direitos
de uso).
É importante que as pautas e os votos sejam persistidos e que não sejam perdidos com o restart da aplicação.
O foco dessa avaliação é a comunicação entre o backend e o aplicativo mobile. Essa comunicação é feita através de mensagens no formato JSON, onde essas mensagens serão interpretadas pelo cliente para montar as telas onde o usuário vai interagir com o sistema. A aplicação cliente não faz parte da avaliação, apenas os componentes do servidor. O formato padrão dessas mensagens será detalhado no anexo 1.

Funcionalidade:
Essa solução deve ser executada na nuvem e promover as seguintes funcionalidades através de
uma API REST
* Cadastrar uma nova pauta
* Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo determinado na chamada de abertura ou 1 minuto por default)
* Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associadoé identificado por um id único e pode votar apenas uma vez por pauta)
* Contabilizar os votos e dar o resultado da votação na pauta


## Notas de Implementação

* No applications.yml existe uma opção que recria o banco H2 ao iniciar a aplicação, para isso não ocorrer basta remover a linha  hibernate:ddl-auto: create

## Modo de Usar
* Faça o download do repositório
* Utilize o wrapper do maven através do comando ./mvnw.
* Além de utilizar o wrapper para criar o Jar. Também é possível cria-lo através da IDE
* Após gerar o .jar utilize o comando java -jar para subir a aplicação
* Utilize a ferramenta Postman para os testes de API, há um .json NA PASTA RESOURCES que pode ser facilmente importado para facilitar os testes


### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.0/maven-plugin/reference/html/)

