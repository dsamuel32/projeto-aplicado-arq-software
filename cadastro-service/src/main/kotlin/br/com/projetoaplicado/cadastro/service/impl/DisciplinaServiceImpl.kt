package br.com.projetoaplicado.cadastro.service.impl

import br.com.projetoaplicado.cadastro.dominio.Disciplina
import br.com.projetoaplicado.cadastro.repository.DisciplinaRepository
import br.com.projetoaplicado.cadastro.service.DisciplinaService
import org.springframework.stereotype.Service

@Service
class DisciplinaServiceImpl(private val disciplinaRepository: DisciplinaRepository) : DisciplinaService {

    override fun getDisciplinas(): List<Disciplina> = disciplinaRepository.findAll()

}