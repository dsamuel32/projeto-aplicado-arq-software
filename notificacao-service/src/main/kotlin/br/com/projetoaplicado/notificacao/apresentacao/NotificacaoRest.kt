package br.com.projetoaplicado.notificacao.apresentacao

import br.com.projetoaplicado.notificacao.dominio.ParametroNotificacao
import br.com.projetoaplicado.notificacao.service.NotificacaoService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = "notificacoes", produces = arrayOf(MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE))
class NotificacaoRest (private val notificacaoService: NotificacaoService){

    @PostMapping("aula/{tipo}")
    @ResponseStatus(HttpStatus.CREATED)
    fun notificarAula(@PathVariable("tipo") tipo: String,
                      @RequestBody parametroNotificacao: ParametroNotificacao)
                      = notificacaoService.notificar(tipo, parametroNotificacao)

    @PostMapping("pagamento/{tipo}")
    @ResponseStatus(HttpStatus.CREATED)
    fun notificarPagamento(@PathVariable("tipo") tipo: String,
                           @RequestBody parametroNotificacao: ParametroNotificacao)
            = notificacaoService.notificar(tipo, parametroNotificacao)

}