package br.com.projetoaplicado.cadastro.dominio

import org.springframework.data.annotation.Id
import java.util.*

open class Pessoa (
        @Id
        var id: String = UUID.randomUUID().toString(),
        var nome: String? = null,
        var sobrenome: String? = null,
        var email: String? = null
)