package br.com.projetoaplicado.cadastro.dominio

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "professores")
data class Professor (
        var disciplinas: List<Disciplina> = mutableListOf()
) : Pessoa()