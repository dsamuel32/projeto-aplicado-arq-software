http://www.linhadecodigo.com.br/artigo/3343/como-documentar-a-arquitetura-de-software.aspx
https://www.infoq.com/br/articles/desmistificando-spring-cloud-netflix
### Arquiteura Projeto Aplicado IGTI (Em Costrução)

Projeto desenvolvido para a disciplina de Projeto Aplicado da pós graduação de Arquitetura de Software do IGTI. Com o objetivo de demostrar uma arquitetura escalavél utilizando como base a stack para construção de micro serviços da Netflix (Eureka, Zull, Hystrix), Spring Boot, Kotlin, MongoDB, Swagger e Docker. 

### Visão geral

- Registro serviços Eureka

![Diagrama de Deploy](https://github.com/dsamuel32/projeto-aplicado-arq-software/blob/master/documentos/visao_geral_registro_eureka.png)

- Chamadas Serviços

![Diagrama de Deploy](https://github.com/dsamuel32/projeto-aplicado-arq-software/blob/master/documentos/visao_geral_chamada_api.png)

### Requisitos não-funcionais
### Mecanismos arquiteturais

MECANISMO DE ANÁLISE | MECANISMO DE DESIGN                                                                          | MECANISMO DE IMPLEMENTAÇÃO
:-------------------:|:--------------------------------------------------------------------------------------------:|:--------------------------:
Persistência         |Banco de dados NOSQL                                                                          | MongoDB
Segurança            |Camada responsável por controlar o acesso as funcinalidades da aplicação                      | Spring Security/Kotlin
Service Discovery    |Serviço responsável por conhecer a localização de todos os serviços                           | Eureka/Spring Cloud/Kotlin
Api Gateway          |Serviço responsável por ser a o ponto de entrada no sistema                                   | Zull/Spring Cloud/Kotlin
Pagamento            |Api da Braspag reponsável por receper os dados do usuário e efetuar o pagamento               | Rest
Zoom                 |Api de video responsável por gerar uma sala de aula e conectar o aluno e professor            | Rest
Back-end             |Camada responsável por implementar as regras de negócio do sistema                            | Spring Boot/Kotlin/Spring Cloud/Rest
Front-end            |Camada resposável em disponibilizar meio do usuário interagir com o sistema                   | ReactJS
Swagger              |Framework responsável por criar a documentação referente aos endpoints das APIs Rest          | -  
### Fundamentação
### Visão de caso de uso
### Componentes

### Implantação

- Criar network dos containers

```
docker create network projeto-aplicado
```

 - Efetuar build dos projetos
```
mvn clean install
```

- Entrar dentro da pasta mongodb > producao executar o script

```
build.sh
```

 - Para criar cada a imagem de cada projeto é necessário executar o script

```
build.sh
```

- Diagrama de Deploy
![Diagrama de Deploy](https://github.com/dsamuel32/projeto-aplicado-arq-software/blob/master/documentos/deploy.jpg)


