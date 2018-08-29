package br.com.projetoaplicado.cadastro.service.impl

import br.com.projetoaplicado.cadastro.dominio.Aluno
import br.com.projetoaplicado.cadastro.repository.AlunoRepository
import br.com.projetoaplicado.cadastro.service.AlunoService
import br.com.projetoaplicado.comum.util.exception.SemResultadoException
import org.springframework.stereotype.Service

@Service
class AlunoServiceImpl (private val alunoRepository: AlunoRepository) : AlunoService {

    override fun getAlunos(): List<Aluno> = alunoRepository.findAll()

    override fun getAlunosPorId(id: String): Aluno
        = alunoRepository.findById(id).orElseThrow { SemResultadoException("Nenhum Aluno Encontrado") }

    override fun salvar(aluno: Aluno): Aluno = alunoRepository.save(aluno)

    override fun atualizar(aluno: Aluno): Aluno = alunoRepository.save(aluno)

    override fun deletar(id: String) {
        alunoRepository.deleteById(id)
    }

}