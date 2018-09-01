package br.com.projetoaplicado.pagamento.dominio

data class Cartao (
        var numero: Long? = null,
        var nome: String? = null,
        var vencimento: String? = null,
        var codigoSeguranca: String? = null,
        var bandeira: String? = null
)