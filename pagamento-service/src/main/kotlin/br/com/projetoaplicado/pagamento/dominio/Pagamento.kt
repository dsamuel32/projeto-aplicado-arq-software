package br.com.projetoaplicado.pagamento.dominio

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*

@Document(collection = "pagamentos")
data class Pagamento (
        @Id
        val id: String = UUID.randomUUID().toString(),
        var idAluno: String? = null,
        var valor: Double? = null,
        var idAgendamento: String? = null,
        var tipoPagamento: TipoPagamento? = null,
        var status: Status = Status.AGUARDANDO_PAGAMENTO,
        var localDateTime: LocalDateTime = LocalDateTime.now(),
        var urlBoleto: String? = null,
        var cartao: Cartao? = null,
        var idBaspag: String? = null
)