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
    @ResponseStatus(HttpStatus.OK)
    fun getAgendamentos(): List<Agendamento> = agendamentoService.getAgendamentos()

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getAgendamentosPorId(@PathVariable("id") id: String) : Agendamento
            = agendamentoService.getAgendamentosPorId(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criar(@RequestBody agendamento: Agendamento) : Agendamento = agendamentoService.criar(agendamento)

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun atualizar(@RequestBody agendamento: Agendamento): Agendamento
            = agendamentoService.atualizar(agendamento)

    @PutMapping("{id}/reservar")
    fun reservar(@PathVariable("id") id: String, @RequestBody parametro: Agendamento): ResponseEntity<Agendamento> {
        var agendamento = agendamentoService.reservar(id, parametro.idAluno as Long)
        return ResponseEntity(agendamento, HttpStatus.OK)
    }

    @PutMapping("{id}/cancelar")
    @ResponseStatus(HttpStatus.OK)
    fun cancelar(@PathVariable("id") id: String): Agendamento = agendamentoService.cancelar(id)

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deletar(@PathVariable("id") id: String) {
        agendamentoService.deletar(id)
    }

}