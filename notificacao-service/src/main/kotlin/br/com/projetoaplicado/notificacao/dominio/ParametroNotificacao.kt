package br.com.projetoaplicado.notificacao.dominio

data class ParametroNotificacao (
        var aluno: Destinatario? = null,
        var professor: Destinatario? = null,
        var idAgendamento: String? = null,
        var idPagamento: String? = null
)