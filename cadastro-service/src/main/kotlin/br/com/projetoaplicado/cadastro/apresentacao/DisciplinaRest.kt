package br.com.projetoaplicado.cadastro.apresentacao

import br.com.projetoaplicado.cadastro.service.DisciplinaService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "disciplinas", produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
class DisciplinaRest (private val disciplinaService: DisciplinaService){

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getDisciplinas() = disciplinaService.getDisciplinas()

}