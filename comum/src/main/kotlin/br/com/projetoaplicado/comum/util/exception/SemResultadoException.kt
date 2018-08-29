package br.com.projetoaplicado.comum.util.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class SemResultadoException (mensagem: String) : RuntimeException(mensagem)
