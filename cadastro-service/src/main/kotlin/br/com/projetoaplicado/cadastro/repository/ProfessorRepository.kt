package br.com.projetoaplicado.cadastro.repository

import br.com.projetoaplicado.cadastro.dominio.Professor
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfessorRepository : MongoRepository<Professor, String> {
}