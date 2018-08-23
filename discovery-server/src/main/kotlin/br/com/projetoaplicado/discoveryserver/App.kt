package br.com.projetoaplicado.discoveryserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class App

fun main(args: Array<String>) {
    runApplication<App>(*args)
}
