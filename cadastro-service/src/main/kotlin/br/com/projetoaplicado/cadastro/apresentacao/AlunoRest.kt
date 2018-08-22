package br.com.projetoaplicado.cadastro.apresentacao

import br.com.projetoaplicado.cadastro.dominio.PessoaDTO
import br.com.projetoaplicado.cadastro.service.AlunoService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "alunos", produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
class AlunoRest (val alunoService: AlunoService){

    @GetMapping
    fun getAlunos(): ResponseEntity<PessoaDTO> {
        val pessoa: PessoaDTO = alunoService.getAlunos()
        return ResponseEntity(pessoa, HttpStatus.OK)
    }

}