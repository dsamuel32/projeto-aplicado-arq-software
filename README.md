### Projeto Aplicado (Em Costrução)

Projeto desenvolvido para a disciplina de Projeto Aplicado da pós graduação de Arquitetura de Software do IGTI. Com o objetivo de demostrar uma arquitetura escalavél utilizando como base a stack para construção de micro serviços da Netflix (Eureka, Zull, Hystrix), Spring Boot, Kotlin, MongoDB, Swagger e Docker. 

### Visão geral

- Registro serviços Eureka

![Diagrama de Deploy](https://github.com/dsamuel32/projeto-aplicado-arq-software/blob/master/documentos/visao_geral_registro_eureka.png)

- Chamadas Serviços

![Diagrama de Deploy](https://github.com/dsamuel32/projeto-aplicado-arq-software/blob/master/documentos/visao_geral_chamada_api.png)

### Requisitos não-funcionais
### Mecanismos arquiteturais
### Fundamentação
### Visão de caso de uso
### Componentes
https://www.infoq.com/br/articles/desmistificando-spring-cloud-netflix
### Implantacao

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


