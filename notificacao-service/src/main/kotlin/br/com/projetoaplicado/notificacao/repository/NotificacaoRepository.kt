package br.com.projetoaplicado.notificacao.repository

import br.com.projetoaplicado.notificacao.dominio.Notificacao
import br.com.projetoaplicado.notificacao.dominio.Status
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface NotificacaoRepository : MongoRepository<Notificacao, String> {

    @Query("{ 'status' : ?0 }")
    fun getNotificacoesPorStatus(status: Status): List<Notificacao>

}