package br.com.projetoaplicado.agendamento.repository

import br.com.projetoaplicado.agendamento.dominio.Agendamento
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface AgendamentoRepository : MongoRepository<Agendamento, String> {
}