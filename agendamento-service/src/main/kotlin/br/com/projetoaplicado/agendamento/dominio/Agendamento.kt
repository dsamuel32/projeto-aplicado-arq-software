package br.com.projetoaplicado.agendamento.dominio

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*

@Document(collection = "agendamentos")
data class Agendamento (
        @Id
        val id: String = UUID.randomUUID().toString(),
        var idAluno: Long = -1,
        var idProfessor: Long = -1,
        var urlAula: String = "",
        var data: LocalDateTime? = null
)