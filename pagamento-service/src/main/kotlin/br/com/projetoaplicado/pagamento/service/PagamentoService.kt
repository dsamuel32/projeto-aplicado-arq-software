package br.com.projetoaplicado.pagamento.service

import br.com.projetoaplicado.pagamento.dominio.Pagamento

interface PagamentoService {


    fun getPagamentos(): List<Pagamento>

    fun getPagamentoPorId(id: String): Pagamento

    fun salvar(tipo: String, pagamento: Pagamento) : Pagamento

    fun salvar(pagamento: Pagamento): Pagamento

    fun cancelar(id: String)

}