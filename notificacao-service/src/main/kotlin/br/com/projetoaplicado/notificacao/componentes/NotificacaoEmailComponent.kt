package br.com.projetoaplicado.notificacao.componentes

import br.com.projetoaplicado.notificacao.dominio.Notificacao
import org.springframework.stereotype.Component

@Component
class NotificacaoEmailComponent : NotificacaoComponent {

    override fun notificar(notificacao: Notificacao) {
        println("Notificando por EMAIL destinatario id: ${notificacao.destinatario?.id} - email ${notificacao.destinatario?.email}")
    }

}