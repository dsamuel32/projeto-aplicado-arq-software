package br.com.projetoaplicado.cadastro.dominio

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "alunos")
data class Aluno(
        var idade: Int? = null,
        var interesses: List<Disciplina> = mutableListOf()
) : Pessoa ()