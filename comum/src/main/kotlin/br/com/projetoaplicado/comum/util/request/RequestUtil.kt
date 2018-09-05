package br.com.projetoaplicado.comum.util.request

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

class RequestUtil() {

    private val restTemplate = RestTemplate()

    fun createHeader(headers: Map<String, String>): HttpHeaders {
        val httpHeaders = HttpHeaders()
        httpHeaders.set("Content-Type", "application/json")

        for ((key, value) in headers) {
            httpHeaders.set(key, value)
        }

        return httpHeaders
    }

    fun post(url: String, body: Any, headers: HttpHeaders): ResponseEntity<*> {
        val entity = HttpEntity(body, headers)
        return restTemplate.exchange(url, HttpMethod.POST, entity, Any::class.java)
    }

}