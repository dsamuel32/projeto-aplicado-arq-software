http://www.linhadecodigo.com.br/artigo/3343/como-documentar-a-arquitetura-de-software.aspx
https://www.infoq.com/br/articles/desmistificando-spring-cloud-netflix
https://github.com/italopaiva/SiMCTA/wiki/Documento-de-arquitetura
### Arquiteura Projeto Aplicado IGTI (Em Costrução) ![Status Build Travis](https://travis-ci.org/dsamuel32/projeto-aplicado-arq-software.svg?branch=master)

Projeto desenvolvido para a disciplina de Projeto Aplicado da pós graduação de Arquitetura de Software do IGTI. Com o objetivo de demostrar uma arquitetura escalavél utilizando Spring Boot, Spring Security, Spring Data, Spring Cloud (Eureka, Zull), Kotlin, MongoDB, Swagger e Docker. 

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
