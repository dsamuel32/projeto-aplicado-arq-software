package br.com.projetoaplicado.notificacao.dominio

enum class TipoNotificacao(codigo: Int, descricao: String) {

    SMS (0, "SMS"),
    EMAIL (1, "EMAIL");

}