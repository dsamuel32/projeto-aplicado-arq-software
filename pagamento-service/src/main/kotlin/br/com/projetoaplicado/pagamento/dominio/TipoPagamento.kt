package br.com.projetoaplicado.pagamento.dominio

enum class TipoPagamento {

    BOLETO (1, "Boleto"),
    CARTAO_CREDITO (2, "Cartão de Crédito");

    private var codigo: Int = 1
    private var descricao: String = "Boleto"

    constructor(codigo: Int, descricao: String) {
        this.codigo = codigo
        this.descricao = descricao
    }

}