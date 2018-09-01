package br.com.projetoaplicado.pagamento.apresentacao

import br.com.projetoaplicado.pagamento.dominio.Pagamento
import br.com.projetoaplicado.pagamento.service.PagamentoService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = "pagamentos", produces = arrayOf(MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE))
class PagamentoRest (val pagamentoService: PagamentoService){


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getPagamentos(): List<Pagamento> = pagamentoService.getPagamentos()

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getPagamentoPorId(@PathVariable("id") id: String): Pagamento
            = pagamentoService.getPagamentoPorId(id)

    @PostMapping("{tipo}")
    @ResponseStatus(HttpStatus.CREATED)
    fun pagar(@PathVariable("tipo") tipo: String, @RequestBody pagamento: Pagamento) : Pagamento
            = pagamentoService.salvar(tipo, pagamento)

    @DeleteMapping("id")
    @ResponseStatus(HttpStatus.OK)
    fun cancelar(@PathVariable("id") id: String) {
        pagamentoService.cancelar(id)
    }

}