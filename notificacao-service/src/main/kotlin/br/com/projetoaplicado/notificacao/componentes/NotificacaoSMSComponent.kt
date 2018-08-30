package br.com.projetoaplicado.notificacao.componentes

import br.com.projetoaplicado.notificacao.dominio.Notificacao
import org.springframework.stereotype.Component

@Component
class NotificacaoSMSComponent : NotificacaoComponent {

    override fun notificar(notificacao: Notificacao) {
        println("Notificando por SMS destinatario id: ${notificacao.destinatario?.id} - email ${notificacao.destinatario?.telefone}")
    }

}