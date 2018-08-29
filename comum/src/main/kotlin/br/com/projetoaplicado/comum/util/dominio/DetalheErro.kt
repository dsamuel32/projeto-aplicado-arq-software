package br.com.projetoaplicado.comum.util.dominio

import java.time.LocalDate

data class DetalheErro (val data: LocalDate, val mensagem: String, val detalhar: String)