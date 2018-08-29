package br.com.projetoaplicado.cadastro.service

import br.com.projetoaplicado.cadastro.dominio.Disciplina

interface DisciplinaService {

    fun getDisciplinas(): List<Disciplina>

}