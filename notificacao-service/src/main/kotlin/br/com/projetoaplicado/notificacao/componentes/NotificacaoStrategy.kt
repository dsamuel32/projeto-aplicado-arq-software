package br.com.projetoaplicado.notificacao.componentes

import br.com.projetoaplicado.notificacao.dominio.Notificacao
import br.com.projetoaplicado.notificacao.dominio.TipoNotificacao
import br.com.projetoaplicado.notificacao.exception.ErroNotificacaoException
import org.springframework.stereotype.Component

@Component
class NotificacaoStrategy (private val notificacaoSMSComponent: NotificacaoSMSComponent,
                           private val notificacaoEmailComponent: NotificacaoEmailComponent) {

    fun notificar(notificacao: Notificacao) {
        var notificaoComponent: NotificacaoComponent = getNotificador(notificacao.tipoNotificacao)

        if (notificaoComponent != null) {
            notificaoComponent.notificar(notificacao)
        }

        throw ErroNotificacaoException("Erro procurar notificador")
    }

    private fun getNotificador(tipoNotificacao: TipoNotificacao) : NotificacaoComponent {
        when(tipoNotificacao) {
            TipoNotificacao.EMAIL -> return notificacaoEmailComponent
            TipoNotificacao.SMS -> return notificacaoSMSComponent
        }

    }
}