package br.com.projetoaplicado.pagamento.exception

import br.com.projetoaplicado.comum.util.dominio.DetalheErro
import br.com.projetoaplicado.comum.util.exception.handler.ResponseExceptionHandler
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import java.time.LocalDate

@ControllerAdvice
@RestController
class PagamentoResponseExceptionHandler : ResponseExceptionHandler() {


    @ExceptionHandler(PagamentoException::class)
    fun handlePagamentoException(ex: PagamentoException, request: WebRequest): ResponseEntity<DetalheErro> {
        val detalheErro = DetalheErro(LocalDate.now(), ex.message!!, request.getDescription(false))
        return ResponseEntity(detalheErro, HttpStatus.INTERNAL_SERVER_ERROR)
    }

}