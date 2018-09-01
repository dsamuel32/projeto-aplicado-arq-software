package br.com.projetoaplicado.pagamento.service.impl

import br.com.projetoaplicado.comum.util.exception.SemResultadoException
import br.com.projetoaplicado.pagamento.dominio.Pagamento
import br.com.projetoaplicado.pagamento.dominio.Status
import br.com.projetoaplicado.pagamento.dominio.TipoPagamento
import br.com.projetoaplicado.pagamento.repository.PagamentoRepository
import br.com.projetoaplicado.pagamento.service.PagamentoService
import org.springframework.stereotype.Service

@Service
class PagamentoServiceImpl (val paramentoRepository: PagamentoRepository) : PagamentoService {


    override  fun getPagamentos(): List<Pagamento> = paramentoRepository.findAll()

    override  fun getPagamentoPorId(id: String): Pagamento
            = paramentoRepository.findById(id).orElseThrow { SemResultadoException("Nenhum Pagamento Encontrado")}

    override fun salvar(tipo: String, pagamento: Pagamento): Pagamento {
       val tipoPagamento = TipoPagamento.valueOf(tipo)
        pagamento.tipoPagamento = tipoPagamento

        return salvar(pagamento)
    }

    override fun salvar(pagamento: Pagamento): Pagamento = paramentoRepository.save(pagamento)

    override fun cancelar(id: String) {
        var pagamento: Pagamento = getPagamentoPorId(id)
   //     pagamento.status = Status.CANCELADO
        salvar(pagamento)
    }

}