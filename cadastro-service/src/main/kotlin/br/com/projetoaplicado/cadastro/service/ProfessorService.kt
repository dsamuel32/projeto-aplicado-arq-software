package br.com.projetoaplicado.cadastro.service

import br.com.projetoaplicado.cadastro.dominio.Professor

interface ProfessorService {

    fun getProfessores(): List<Professor>

    fun getProfessorPorId(id: String): Professor

    fun salvar(professor: Professor): Professor

    fun alterar(professor: Professor): Professor

    fun deletar(id: String)

}