package br.com.projetoaplicado.agendamento.dominio

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*

@Document(collection = "agendamentos")
data class Agendamento (
        @Id
        val id: String = UUID.randomUUID().toString(),
        var idAluno: Long? = null,
        var idProfessor: Long? = null,
        var urlAula: String? = null,
        var data: LocalDateTime? = null,
        var disciplina: String? = null
)