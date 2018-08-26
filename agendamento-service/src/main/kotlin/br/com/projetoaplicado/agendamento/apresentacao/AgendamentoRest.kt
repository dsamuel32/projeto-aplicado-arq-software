package br.com.projetoaplicado.agendamento.apresentacao

import br.com.projetoaplicado.agendamento.dominio.AgendamentoDTO
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = "agendamentos", produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
class AgendamentoRest {

    @GetMapping
    fun getAgendamentos(): ResponseEntity<List<AgendamentoDTO>> {
        return ResponseEntity(null, HttpStatus.OK)
    }

    @GetMapping(value = "{id}")
    fun getAgendamentosPorId(@PathVariable("id") id: Long) : ResponseEntity<AgendamentoDTO> {
        return ResponseEntity(null, HttpStatus.OK)
    }

    @PostMapping
    fun agendar(@RequestBody agendamentoDTO: AgendamentoDTO) : ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.CREATED)
    }

    @PutMapping
    fun atualizar(@RequestBody agendamentoDTO: AgendamentoDTO): ResponseEntity<AgendamentoDTO> {
        return ResponseEntity(null, HttpStatus.OK)
    }

    @DeleteMapping(value = "{id}")
    fun deletar(@PathVariable("id") id: Long): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.OK)
    }

}