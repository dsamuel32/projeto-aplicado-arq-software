package br.com.projetoaplicado.cadastro.apresentacao

import br.com.projetoaplicado.cadastro.dominio.Aluno
import br.com.projetoaplicado.cadastro.dominio.Professor
import br.com.projetoaplicado.cadastro.service.ProfessorService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = "professores", produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
class ProfessorRest (private val professorService: ProfessorService){

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getProfessores(): List<Professor> = professorService.getProfessores()

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getProfessorPorId(@PathVariable("id") id: String) = professorService.getProfessorPorId(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvar(@RequestBody professor: Professor) = professorService.salvar(professor)

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun atualizar(@RequestBody professor: Professor) = professorService.alterar(professor)

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deletar(@PathVariable("id") id: String) {
        professorService.deletar(id)
    }

}