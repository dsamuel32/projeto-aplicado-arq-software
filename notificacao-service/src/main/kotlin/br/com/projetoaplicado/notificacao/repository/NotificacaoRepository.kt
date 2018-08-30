package br.com.projetoaplicado.notificacao.repository

import br.com.projetoaplicado.notificacao.dominio.Notificacao
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface NotificacaoRepository : MongoRepository<Notificacao, String> {
}