package br.com.projetoaplicado.cadastro.apresentacao

import br.com.projetoaplicado.cadastro.dominio.Aluno
import br.com.projetoaplicado.cadastro.service.AlunoService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = "alunos", produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
class AlunoRest (val alunoService: AlunoService){

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAlunos(): List<Aluno> = alunoService.getAlunos()

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getAlunosPorId(@PathVariable("id") id: String) = alunoService.getAlunosPorId(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvar(@RequestBody aluno: Aluno) = alunoService.salvar(aluno)

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun atualizar(@RequestBody aluno: Aluno) = alunoService.salvar(aluno)

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deletar(@PathVariable("id") id: String) {
        alunoService.deletar(id)
    }

}