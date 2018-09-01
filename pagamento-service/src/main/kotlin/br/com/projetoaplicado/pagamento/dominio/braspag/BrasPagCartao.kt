package br.com.projetoaplicado.pagamento.dominio.braspag

data class BrasPagCartao(
        var MerchantOrderId: String,
        var Costomer: Costumer,
        var Payment: Payment
)



