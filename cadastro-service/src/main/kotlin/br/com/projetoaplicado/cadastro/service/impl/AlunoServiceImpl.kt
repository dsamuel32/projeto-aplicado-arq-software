package br.com.projetoaplicado.cadastro.service.impl

import br.com.projetoaplicado.cadastro.dominio.Pessoa
import br.com.projetoaplicado.cadastro.dominio.PessoaDTO
import br.com.projetoaplicado.cadastro.service.AlunoService
import br.com.projetoaplicado.comum.util.ModelMapperConverter
import org.springframework.stereotype.Service

@Service
class AlunoServiceImpl : AlunoService {

    override fun getAlunos(): PessoaDTO {
        var pessoa = Pessoa("Diego", "Samuel")
        var mapper = ModelMapperConverter()
        return mapper.converter(pessoa, PessoaDTO::class.java) as PessoaDTO
    }

}