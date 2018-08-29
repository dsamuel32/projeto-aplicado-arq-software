package br.com.projetoaplicado.cadastro.service

import br.com.projetoaplicado.cadastro.dominio.Aluno

interface AlunoService {

    fun getAlunos(): List<Aluno>

    fun getAlunosPorId(id: String): Aluno

    fun salvar(aluno: Aluno): Aluno

    fun atualizar(aluno: Aluno): Aluno

    fun deletar(id: String)

}