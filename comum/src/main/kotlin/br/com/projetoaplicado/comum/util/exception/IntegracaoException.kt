package br.com.projetoaplicado.comum.util.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
class IntegracaoException(mensagem: String) : RuntimeException (mensagem)