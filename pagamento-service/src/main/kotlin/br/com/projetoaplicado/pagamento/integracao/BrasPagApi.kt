package br.com.projetoaplicado.pagamento.integracao

import br.com.projetoaplicado.comum.util.request.RequestUtil
import br.com.projetoaplicado.pagamento.dominio.Pagamento
import br.com.projetoaplicado.pagamento.dominio.braspag.BrasPagCartao
import br.com.projetoaplicado.pagamento.dominio.braspag.Custumer
import br.com.projetoaplicado.pagamento.dominio.braspag.CreditCard
import br.com.projetoaplicado.pagamento.dominio.braspag.Payment
import br.com.projetoaplicado.pagamento.exception.PagamentoException
import org.omg.CORBA.Object
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class BrasPagApi {

    @Value("\${url.api}")
    private var urlBrasPag: String = ""

    @Value("\${merchantId}")
    private var merchantId: String = ""

    @Value("\${merchantKey}")
    private var merchantKey: String = ""

    private val restTemplate = RestTemplate()

    fun pagarCartaoCredito(pagamento: Pagamento): String {
        val requestUtil: RequestUtil = RequestUtil()

        val cartao = pagamento.cartao
        var custumer = Custumer(pagamento.idAluno as String)
        var creditCard = CreditCard(cartao?.numero as Long, cartao?.nome as String, cartao?.vencimento as String, cartao.codigoSeguranca as Int, cartao.bandeira as String)
        var payment = Payment(Provider = "Simulado", Type = "CreditCard", Amount = pagamento?.valor as Double, CreditCard = creditCard)
        val brasPagCartao = BrasPagCartao(pagamento.idAgendamento as String, custumer, payment)
        val httpHeaders = requestUtil.createHeader(mapOf("MerchantId" to merchantId, "MerchantKey" to merchantKey))
        val resposta = requestUtil.post("${urlBrasPag}v2/sales", brasPagCartao, httpHeaders)

        if (resposta.statusCode == HttpStatus.CREATED) {
            val brasPagPagamento = resposta.body as Map<String, Object>
            val payment = brasPagPagamento["Payment"] as Map<String, Object>
            return payment["PaymentId"] as String
        } else if (resposta.statusCode == HttpStatus.BAD_REQUEST) {
            throw PagamentoException("Parametros do pagamento invalido")
        }

        throw PagamentoException("Erro ao executar o pagamento api indonivel")

    }

}