package br.com.projetoaplicado.agendamento.integracao

import io.jsonwebtoken.JwtBuilder
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.io.UnsupportedEncodingException
import java.util.*

class TokenUtil (val apiKey: String, val secret: String){

    private val TEMPO_EXPIRAR = 60000L

    fun criarJwtToken(): String {
        var now = Date()
        val exp = now.time + TEMPO_EXPIRAR
        val header = criarHeders()
        return gerarToken(header, Date(exp))
    }

    private fun criarHeders() : Map<String, String> =  mapOf("alg" to "HS256", "typ" to "JWT")

    private fun gerarToken(header: Map<String, String>, dataExp: Date) : String {
        var builder: JwtBuilder
        try {
            builder = Jwts.builder()
                    .setIssuer(apiKey)
                    .setHeader(header)
                    .setExpiration(dataExp)
                    .signWith(SignatureAlgorithm.HS256, secret.toByteArray(charset("UTF-8")))
        } catch (e : UnsupportedEncodingException) {
            throw RuntimeException(e);
        }

        return builder.compact();
    }

}