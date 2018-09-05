package br.com.projetoaplicado.pagamento.dominio.braspag

data class BrasPagCartao(
        var MerchantOrderId: String,
        var Customer: Custumer,
        var Payment: Payment
)



