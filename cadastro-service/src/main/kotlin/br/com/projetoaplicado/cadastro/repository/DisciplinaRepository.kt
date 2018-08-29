package br.com.projetoaplicado.cadastro.repository

import br.com.projetoaplicado.cadastro.dominio.Disciplina
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface DisciplinaRepository : MongoRepository<Disciplina, String>{
}