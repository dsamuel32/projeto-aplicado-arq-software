package br.com.projetoaplicado.pagamento.dominio.braspag

data class Payment (
        var Provider: String,
        var Type: String,
        var Amount: Double,
        var Capture: Boolean = true,
        var Installments: Int = 1,
        var CreditCard: CreditCard
)