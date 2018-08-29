package br.com.projetoaplicado.comum.util.exception.handler

import br.com.projetoaplicado.comum.util.dominio.DetalheErro
import br.com.projetoaplicado.comum.util.exception.IntegracaoException
import br.com.projetoaplicado.comum.util.exception.SemResultadoException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDate

open class ResponseExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleUserNotFoundException(ex: Exception, request: WebRequest): ResponseEntity<DetalheErro> {
        val detalheErro = DetalheErro(LocalDate.now(), ex.message!!, request.getDescription(false))
        return ResponseEntity(detalheErro, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(SemResultadoException::class)
    fun handleSemResultado(ex: SemResultadoException, request: WebRequest): ResponseEntity<DetalheErro> {
        val detalheErro = DetalheErro(LocalDate.now(), ex.message!!, request.getDescription(false))
        return ResponseEntity(detalheErro, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(IntegracaoException::class)
    fun handleIntegracaoException(ex: IntegracaoException, request: WebRequest): ResponseEntity<DetalheErro> {
        val detalheErro = DetalheErro(LocalDate.now(), ex.message!!, request.getDescription(false))
        return ResponseEntity(detalheErro, HttpStatus.INTERNAL_SERVER_ERROR)
    }

}