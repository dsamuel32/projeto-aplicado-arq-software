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
        val notificacoes: List<Notificacao> = notificacaoService.getNotificacoesPorStatus(Status.PENDENDE)

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