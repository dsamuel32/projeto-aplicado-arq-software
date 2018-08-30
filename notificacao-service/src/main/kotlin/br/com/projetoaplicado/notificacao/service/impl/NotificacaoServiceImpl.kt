package br.com.projetoaplicado.notificacao.service.impl

import br.com.projetoaplicado.notificacao.dominio.Notificacao
import br.com.projetoaplicado.notificacao.dominio.ParametroNotificacao
import br.com.projetoaplicado.notificacao.dominio.Status
import br.com.projetoaplicado.notificacao.dominio.TipoNotificacao
import br.com.projetoaplicado.notificacao.repository.NotificacaoRepository
import br.com.projetoaplicado.notificacao.service.NotificacaoService
import org.springframework.stereotype.Service

@Service
class NotificacaoServiceImpl (private val notificacaoRepository: NotificacaoRepository) : NotificacaoService {

    override fun getNotificacoes(): List<Notificacao> = notificacaoRepository.findAll()

    override fun getNotificacoesPorStatus(status: Status): List<Notificacao> {
        return mutableListOf()
    }

    override fun salvar(notificacao: Notificacao): Notificacao {
        return notificacaoRepository.save(notificacao)
    }

    override fun notificar(tipo: String, parametroNotificacao: ParametroNotificacao) {
        val tipoNotificacao: TipoNotificacao = TipoNotificacao.valueOf(tipo)
        salvarNotificacaoAluno(tipoNotificacao, parametroNotificacao)
        salvarNotificacaoProfessor(tipoNotificacao, parametroNotificacao)

    }

    private fun salvarNotificacaoAluno(tipoNotificacao: TipoNotificacao, parametroNotificacao: ParametroNotificacao) {
        if (parametroNotificacao.professor != null) {
            val notificacao = Notificacao(tipoNotificacao = tipoNotificacao, destinatario = parametroNotificacao.aluno, idAgendamento = parametroNotificacao.idAgendamento, idPagamento = parametroNotificacao.idPagamento)
            salvar(notificacao)
        }
    }

    private fun salvarNotificacaoProfessor(tipoNotificacao: TipoNotificacao, parametroNotificacao: ParametroNotificacao) {
        if (parametroNotificacao.professor != null) {
            val notificacao = Notificacao(tipoNotificacao = tipoNotificacao, destinatario = parametroNotificacao.professor, idAgendamento = parametroNotificacao.idAgendamento)
            salvar(notificacao)
        }
    }

}