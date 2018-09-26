package br.com.projetoaplicado.comum.util.dominio.pagamento

import java.time.LocalDateTime

data class PagamentoDTO (
        var idAluno: String? = null,
        var valor: Double? = null,
        var idAgendamento: String? = null,
        var status: String = "AGUARDANDO_PAGAMENTO",
        var localDateTime: LocalDateTime = LocalDateTime.now(),
        var urlBoleto: String? = null,
        var cartao: CartaoDTO? = null,
        var idBaspag: String? = null
)