package br.com.projetoaplicado.agendamento.apresentacao

import br.com.projetoaplicado.agendamento.dominio.Agendamento
import br.com.projetoaplicado.agendamento.servico.AgendamentoService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = "agendamentos", produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
class AgendamentoRest (private val agendamentoService: AgendamentoService) {

    @GetMapping
    fun getAgendamentos(): ResponseEntity<List<Agendamento>> {
        val agendamentos = agendamentoService.getAgendamentos()
        return ResponseEntity(agendamentos, HttpStatus.OK)
    }

    @GetMapping(value = "{id}")
    fun getAgendamentosPorId(@PathVariable("id") id: String) : ResponseEntity<Agendamento> {
        val agendamento = agendamentoService.getAgendamentosPorId(id)
        return ResponseEntity(agendamento, HttpStatus.OK)
    }

    @PostMapping
    fun agendar(@RequestBody agendamento: Agendamento) : ResponseEntity<Any> {
        val agendamentoSalvo = agendamentoService.agendar(agendamento)
        return ResponseEntity(agendamentoSalvo, HttpStatus.CREATED)
    }

    @PutMapping
    fun atualizar(@RequestBody agendamento: Agendamento): ResponseEntity<Agendamento> {
        val agendamentoDTOAtualizado = agendamentoService.atualizar(agendamento)
        return ResponseEntity(agendamentoDTOAtualizado, HttpStatus.OK)
    }

    @DeleteMapping(value = "{id}")
    fun deletar(@PathVariable("id") id: String): ResponseEntity<Any> {
        agendamentoService.deletar(id)
        return ResponseEntity(HttpStatus.OK)
    }

}