package br.com.projetoaplicado.pagamento.repository

import br.com.projetoaplicado.pagamento.dominio.Pagamento
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PagamentoRepository : MongoRepository<Pagamento, String>{
}