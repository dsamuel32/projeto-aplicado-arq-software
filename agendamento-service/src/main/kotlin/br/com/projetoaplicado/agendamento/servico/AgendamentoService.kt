package br.com.projetoaplicado.agendamento.servico

import br.com.projetoaplicado.agendamento.dominio.Agendamento

interface AgendamentoService {

    fun getAgendamentos() : List<Agendamento>

    fun getAgendamentosPorId(id: String): Agendamento

    fun criar(agendamentoDTO: Agendamento) : Agendamento

    fun atualizar(agendamentoDTO: Agendamento) : Agendamento

    fun deletar(id: String)

    fun reservar(id: String, idAluno: Long): Agendamento

    fun cancelar(id: String): Agendamento

}