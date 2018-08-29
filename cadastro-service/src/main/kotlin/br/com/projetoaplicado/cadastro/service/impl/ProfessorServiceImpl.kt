package br.com.projetoaplicado.cadastro.service.impl

import br.com.projetoaplicado.cadastro.dominio.Professor
import br.com.projetoaplicado.cadastro.repository.ProfessorRepository
import br.com.projetoaplicado.cadastro.service.ProfessorService
import br.com.projetoaplicado.comum.util.exception.SemResultadoException
import org.springframework.stereotype.Service

@Service
class ProfessorServiceImpl(private val professorRepository: ProfessorRepository) : ProfessorService {

    override fun getProfessores(): List<Professor> = professorRepository.findAll()

    override fun getProfessorPorId(id: String): Professor
            = professorRepository.findById(id).orElseThrow { SemResultadoException("Nenhum Professor Encontrado") }

    override fun salvar(professor: Professor): Professor = professorRepository.save(professor)

    override fun alterar(professor: Professor): Professor = professorRepository.save(professor)

    override fun deletar(id: String) {
        professorRepository.deleteById(id)
    }

}