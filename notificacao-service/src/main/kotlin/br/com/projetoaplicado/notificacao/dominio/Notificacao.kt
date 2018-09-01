package br.com.projetoaplicado.notificacao.dominio

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "notificacoes")
data class Notificacao (
        @Id
        var id: String = UUID.randomUUID().toString(),
        var tipoNotificacao: TipoNotificacao = TipoNotificacao.EMAIL,
        var tentativas: Int = 0,
        var destinatario: Destinatario? = null,
        var status: Status = Status.PENDENTE,
        var mensagensErros: List<String> = mutableListOf(),
        var idAgendamento: String? = null,
        var idPagamento: String? = null
)