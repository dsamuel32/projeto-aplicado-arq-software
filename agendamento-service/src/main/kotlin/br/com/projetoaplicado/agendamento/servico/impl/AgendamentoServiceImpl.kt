package br.com.projetoaplicado.agendamento.servico.impl

import br.com.projetoaplicado.agendamento.dominio.AgendamentoDTO
import br.com.projetoaplicado.agendamento.servico.AgendamentoService
import org.springframework.stereotype.Service

@Service
class AgendamentoServiceImpl : AgendamentoService {

    override fun getAgendamentos(): List<AgendamentoDTO> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAgendamentosPorId(id: Long): List<AgendamentoDTO> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun agendar(agendamentoDTO: AgendamentoDTO): AgendamentoDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun atualizar(agendamentoDTO: AgendamentoDTO): AgendamentoDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deletar(id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}