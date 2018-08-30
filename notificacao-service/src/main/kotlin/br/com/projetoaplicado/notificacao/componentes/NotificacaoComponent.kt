package br.com.projetoaplicado.notificacao.componentes

import br.com.projetoaplicado.notificacao.dominio.Notificacao

interface NotificacaoComponent {

    fun notificar(notificacao: Notificacao)

}