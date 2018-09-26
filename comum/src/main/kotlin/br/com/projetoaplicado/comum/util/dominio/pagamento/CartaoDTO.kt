package br.com.projetoaplicado.comum.util.dominio.pagamento

data class CartaoDTO (
        var numero: Long? = null,
        var nome: String? = null,
        var vencimento: String? = null,
        var codigoSeguranca: Int? = null,
        var bandeira: String? = null
)