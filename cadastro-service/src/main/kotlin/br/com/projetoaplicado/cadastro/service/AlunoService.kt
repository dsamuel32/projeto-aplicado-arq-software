package br.com.projetoaplicado.cadastro.service

import br.com.projetoaplicado.cadastro.dominio.PessoaDTO

interface AlunoService {

    fun getAlunos(): PessoaDTO

}