package br.com.projetoaplicado.agendamento.servico.impl

import br.com.projetoaplicado.agendamento.dominio.Agendamento
import br.com.projetoaplicado.agendamento.repository.AgendamentoRepository
import br.com.projetoaplicado.agendamento.servico.AgendamentoService
import org.springframework.stereotype.Service

@Service
class AgendamentoServiceImpl (private val agendamentoRepository: AgendamentoRepository) : AgendamentoService {

    override fun getAgendamentos(): List<Agendamento> = agendamentoRepository.findAll()

    override fun getAgendamentosPorId(id: String): Agendamento =
            agendamentoRepository.findById(id).orElseThrow { RuntimeException() }

    override fun agendar(agendamento: Agendamento): Agendamento {
        agendamento.urlAula = "https://www.google.com"
        return agendamentoRepository.save(agendamento)
    }

    override fun atualizar(agendamento: Agendamento): Agendamento = agendamentoRepository.save(agendamento)

    override fun deletar(id: String) {
        agendamentoRepository.deleteById(id)
    }

}