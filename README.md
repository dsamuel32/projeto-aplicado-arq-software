http://www.linhadecodigo.com.br/artigo/3343/como-documentar-a-arquitetura-de-software.aspx
https://www.infoq.com/br/articles/desmistificando-spring-cloud-netflix
https://github.com/italopaiva/SiMCTA/wiki/Documento-de-arquitetura
### Arquiteura Projeto Aplicado IGTI (Em Costrução) ![Status Build Travis](https://travis-ci.org/dsamuel32/projeto-aplicado-arq-software.svg?branch=master)

### 1 - Introdução

Projeto desenvolvido para a disciplina de Projeto Aplicado da pós graduação de Arquitetura de Software do IGTI. Com o objetivo de demostrar uma arquitetura escalavél utilizando Spring Boot, Spring Security, Spring Data, Spring Cloud (Eureka, Zull), Kotlin, MongoDB, Swagger e Docker. 

### 2 - Visão geral

Nesta seção será apresentado como os componentes da aquitetura e como esses componentes serão organizado internamente.

**2.1 - Registro serviços Eureka**

A imagem abaixo demostra como os serviços vão ser registrados no módulo de discovery service (Eureka).

![Diagrama de Deploy](https://github.com/dsamuel32/projeto-aplicado-arq-software/blob/master/documentos/visao_geral_registro_eureka.png)

**2.2 - Chamadas Serviços**

A imagem abaixo mostra como os serviços vão se comunicar via api gateway (Zull).

![Diagrama de Deploy](https://github.com/dsamuel32/projeto-aplicado-arq-software/blob/master/documentos/visao_geral_chamada_api.png)

**2.3 - Organização Interna dos Micro Serviços**

Cada micro serviço será composto pelas seguintes camadas Model, View, Controller e DAO.

A camada Model é responsável por estabelecer o domínio da aplicação na solução proposta, inerentes ao contexto. Ela se comunica diretamente apenas com as camadas Controller e DAO.

A camada Controller é responsável por processar as informações provenientes da View, ou seja, informações solicitadas pelo usuário, controlando o fluxo da aplicação e utilizando ou alterando dados da Model. Essa camada também estabelece comunicação com o banco de dados por intermédio da camada DAO.

Dessa forma, a camada DAO (Data Access Object) é responsável por realizar a persistência no banco de dados.

Na imagem abaixo pode ser vista a estrutura de comunicação estabelecida entre as camadas.

![Imagem MVC](https://github.com/dsamuel32/projeto-aplicado-arq-software/blob/master/documentos/mvc.png)

### 3 -Requisitos não-funcionais

### 4 -Mecanismos arquiteturais

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
Integração continua  |Verificação para garantir que o sistema esteja sempre com o build em perfeitas condições      | Travis
Deploy               |Configuração do deploy automatizado                                                           | Jenkins


### 5 - Fundamentação

Nesta seção será apresentado as APIs necessárias para a construção do sistema frameworks, tecnologias utilizadas e as integrações com sistemas de terceiros.

- APIs
    - Cadastro Aluno/Professor: Serviço responsável por manter os cadastros dos usuários (alunos/professores).
    - Notificação: Serviço responsável por enviar notificações aos usuários. Ex: Quando um aluno agendar uma aula.
    - Pagamento: Serviço responsável por controlar o pagamento das aulas e se integrar com o sistema de pagamentos da Braspag.
    - Agendamento: Serviço responsável por disponibilizar ao professor a forma de cadastrar aulas e que o aluno agende e se integre com a API do Zoom.
    - Relatório: Serviço responsável por disponibilizar relatórios aos usuários.

- Frameworks/Tecnologia
    - Spring Boot: Framework que permite a construção de aplicações stand-alone baseadas no framework Spring de forma fácil e rápida, pois já vem com Embed Tomcat, Jetty or Undertow embarcados (sem necessidade de gerar um arquivo WAR) e não existe a necessidade de efetuar muitas configurações.  
    - Spring Security: Framework consolidado no mercado focado em autenticação e autorização de usuários em aplicações Java, altamente customizado.
    - Spring Cloud: Framework que incorporou a statc de micro serviços da Netflix que nos prove ferramentas para um rápido desenvolvimento de aplicações distribuídas com os principais padrões de mercado (configuration management, service discovery, circuit breakers, intelligent routing, micro-proxy, control bus, one-time tokens, global locks, leadership election, distributed sessions, cluster state).
    - Spring Data: Framework prove um fácil acesso a dados com diversas tecnologias com bancos relacionais e NOSQL alem de diponibilzar formas de acesso através de ORM.
    - ReactJS: Framework para construção de componentes web baseado em Javascrit, com uma grande aceitação pela comunidade e de fácil compreenssão.
    - Kotlin: Linguagem de programação orientada a objetos e com uma pegada funcional, executada na JVM, reduz extremamente o boilerplate de códigos, além de ser totalmente compativél com bibliotecas Java.
    
- APIs de Terceiros
    - Zoom: API para criação de uma sala virtual onde acontecerá a interação entre professor e aluno. Escolhida nesse primeiro momento pelo fato de transmissão de vídeo ser algo complexo e por nos disponibilizar todos os recursos necessários para atender bem tanto aluno como professor. 
    - Braspag: API de pagamento da Cielo escolhida por ser de uma empresa forte no mercado de pagamento e disponibilizar varias formas de integração (Rest/SOAP).

### 6 - Visão de caso de uso
### 7 - Componentes

### 8 - Implantação

O sistema será implantado em um ambiente em nuvem da AWS, onde cada micro serviço vai ser executado em um container Docker. Segue abaixo o passo a passo para build das aplicações.

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


