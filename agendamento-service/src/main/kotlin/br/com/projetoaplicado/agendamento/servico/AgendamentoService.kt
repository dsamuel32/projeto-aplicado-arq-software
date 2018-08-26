package br.com.projetoaplicado.agendamento.servico

import br.com.projetoaplicado.agendamento.dominio.AgendamentoDTO

interface AgendamentoService {

    fun getAgendamentos() : List<AgendamentoDTO>

    fun getAgendamentosPorId(id: Long): List<AgendamentoDTO>

    fun agendar(agendamentoDTO: AgendamentoDTO) : AgendamentoDTO

    fun atualizar(agendamentoDTO: AgendamentoDTO) : AgendamentoDTO

    fun deletar(id: Long)

}