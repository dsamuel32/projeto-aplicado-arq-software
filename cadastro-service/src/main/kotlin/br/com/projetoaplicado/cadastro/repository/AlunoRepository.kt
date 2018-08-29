package br.com.projetoaplicado.cadastro.repository

import br.com.projetoaplicado.cadastro.dominio.Aluno
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface AlunoRepository : MongoRepository<Aluno, String> {
}