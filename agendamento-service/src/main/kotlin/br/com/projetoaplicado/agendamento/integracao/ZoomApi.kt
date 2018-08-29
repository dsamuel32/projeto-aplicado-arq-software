package br.com.projetoaplicado.agendamento.integracao

import br.com.projetoaplicado.comum.util.exception.IntegracaoException
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.*
import org.springframework.http.HttpStatus.*
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate


@Component
class ZoomApi {

    @Value("\${key}")
    private val apiKey: String? = null

    @Value("\${secret}")
    private val secret: String? = null

    @Value("\${idUsuario}")
    private val idUsuario: String? = null

    private val restTemplate = RestTemplate()

    fun criarReuniao(): Map<String, Any> {

        if (apiKey != null && secret != null) {
            val tokenUtil = TokenUtil(apiKey, secret)
            val jwt = "Bearer " + tokenUtil.criarJwtToken()
            val headers = criarHeaders(jwt)
            val parametros = criarParametros()
            val response = executarRequisicao(parametros, headers)

            if (response.statusCode == CREATED) {
                return response.body as Map<String, Any>
            }
        }

        throw IntegracaoException("Erro criar aula zoom")
    }

    private fun criarHeaders(jwt: String): HttpHeaders {
        val headers = HttpHeaders()
        headers.set("Authorization", jwt)
        headers.set("Content-Type", "application/json")
        return headers
    }

    private fun criarParametros(): Map<String, Any> {
        val parametrosItens = mapOf("retristration_type" to 2)
        return mapOf("settings" to parametrosItens)
    }

    private fun executarRequisicao(parametros: Map<String, Any>, headers: HttpHeaders): ResponseEntity<*> {
        val entity = HttpEntity(parametros, headers)
        return restTemplate.exchange("https://api.zoom.us/v2/users/$idUsuario/meetings", HttpMethod.POST, entity, Any::class.java)

    }
}