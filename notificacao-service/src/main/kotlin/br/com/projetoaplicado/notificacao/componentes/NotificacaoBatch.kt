package br.com.projetoaplicado.notificacao.componentes

import br.com.projetoaplicado.notificacao.dominio.Notificacao
import br.com.projetoaplicado.notificacao.dominio.Status
import br.com.projetoaplicado.notificacao.exception.ErroNotificacaoException
import br.com.projetoaplicado.notificacao.service.NotificacaoService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class NotificacaoBatch (val notificacaoService: NotificacaoService,
                        val notificacaoStrategy: NotificacaoStrategy) {

    @Scheduled(fixedRate = 5000)
    fun notificar() {
        val pendentes: List<Notificacao> = notificacaoService.getNotificacoesPorStatus(Status.PENDENTE)
        val comErros: List<Notificacao> = notificacaoService.getNotificacoesPorStatus(Status.COM_ERRO)
        println("[NOTIFICACOES] PENDENTES - ${pendentes?.size}")
        println("[NOTIFICACOES] COM ERRO  - ${comErros?.size}")
        processarNotificacoes(pendentes)
        processarNotificacoes(comErros)

    }

    private fun processarNotificacoes(notificacoes: List<Notificacao>) {
        for (notificacao in notificacoes) {
            try {
                notificacaoStrategy.notificar(notificacao)
                notificacao.status = Status.ENVIADO
            } catch (e: ErroNotificacaoException) {
                notificacao.status = Status.COM_ERRO
                notificacao.tentativas =+ 1
                notificacao.mensagensErros.lastIndexOf(e.message)
            }
            notificacaoService.salvar(notificacao)
        }
    }
}