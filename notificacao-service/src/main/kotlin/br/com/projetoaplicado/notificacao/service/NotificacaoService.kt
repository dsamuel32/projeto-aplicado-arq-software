package br.com.projetoaplicado.notificacao.service

import br.com.projetoaplicado.notificacao.dominio.Notificacao
import br.com.projetoaplicado.notificacao.dominio.ParametroNotificacao
import br.com.projetoaplicado.notificacao.dominio.Status

interface NotificacaoService {

    fun getNotificacoes(): List<Notificacao>

    fun getNotificacoesPorStatus(status: Status): List<Notificacao>

    fun salvar(notificacao: Notificacao): Notificacao

    fun notificar(tipo: String, parametroNotificacao: ParametroNotificacao)

}