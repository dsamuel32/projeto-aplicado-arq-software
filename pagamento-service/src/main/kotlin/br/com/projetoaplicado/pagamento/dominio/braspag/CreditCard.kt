package br.com.projetoaplicado.pagamento.dominio.braspag

data class CreditCard (
        var CardNumber: Long,
        var Holder: String,
        var ExpirationDate: String,
        var SecurityCode: Int,
        var Brand: String
)