package br.com.projetoaplicado.agendamento.servico

import br.com.projetoaplicado.agendamento.dominio.Agendamento

interface AgendamentoService {

    fun getAgendamentos() : List<Agendamento>

    fun getAgendamentosPorId(id: String): Agendamento

    fun agendar(agendamentoDTO: Agendamento) : Agendamento

    fun atualizar(agendamentoDTO: Agendamento) : Agendamento

    fun deletar(id: String)

}