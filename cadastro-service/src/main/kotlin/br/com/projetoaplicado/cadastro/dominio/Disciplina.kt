package br.com.projetoaplicado.cadastro.dominio

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "disciplinas")
data class Disciplina (
        @Id
        var id: String? = null,
        var descricao: String? = null
) {
}