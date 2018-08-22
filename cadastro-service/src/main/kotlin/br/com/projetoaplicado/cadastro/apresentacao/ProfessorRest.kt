package br.com.projetoaplicado.cadastro.apresentacao

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "professores", produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
class ProfessorRest {
}