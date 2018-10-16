### Projeto Aplicado (Em Costrução)

Projeto desenvolvido para a disciplina de Projeto Aplicado da pós graduação de Arquitetura de Software do IGTI. 

### Objetivo

Demostrar uma arquitetura escalavél de micro serviços utilizando:
- Eureka
- Zull
- Hystrix
- Spring Boot
- Kotlin
- MongoDB
- Swagger
- Docker

### Requisitos
 - Docker
 - JDK 8
 - Maven

### Primeiros passos
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
### Arquitetura
 -### Visão geral
 -### Diagrama de Deploy
![Diagrama de Deploy](https://github.com/dsamuel32/projeto-aplicado-arq-software/blob/master/documentos/deploy.jpg)
 -### Diagrama de Componentes
https://www.infoq.com/br/articles/desmistificando-spring-cloud-netflix
