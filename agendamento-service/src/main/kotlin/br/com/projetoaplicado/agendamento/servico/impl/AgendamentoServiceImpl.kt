package br.com.projetoaplicado.agendamento.servico.impl

import br.com.projetoaplicado.agendamento.dominio.Agendamento
import br.com.projetoaplicado.agendamento.repository.AgendamentoRepository
import br.com.projetoaplicado.agendamento.servico.AgendamentoService
import br.com.projetoaplicado.comum.util.exception.SemResultadoException
import org.springframework.stereotype.Service

@Service
class AgendamentoServiceImpl (private val agendamentoRepository: AgendamentoRepository) : AgendamentoService {

    override fun getAgendamentos(): List<Agendamento> = agendamentoRepository.findAll()

    override fun getAgendamentosPorId(id: String): Agendamento =
            agendamentoRepository.findById(id).orElseThrow { SemResultadoException("Nenhum Resultado Encontrado") }

    override fun criar(agendamento: Agendamento): Agendamento {
        return agendamentoRepository.save(agendamento)
    }

    override fun atualizar(agendamento: Agendamento): Agendamento = agendamentoRepository.save(agendamento)

    override fun deletar(id: String) {
        agendamentoRepository.deleteById(id)
    }

    override fun reservar(id: String, idAluno: Long): Agendamento {
        var agendamento = getAgendamentosPorId(id)
        agendamento.urlAula = "https://www.google.com"
        agendamento.idAluno = idAluno
        return atualizar(agendamento)
    }

    override fun cancelar(id: String): Agendamento {
        var agendamento = getAgendamentosPorId(id)
        agendamento.idAluno = null
        return atualizar(agendamento)
    }

}