package br.com.projetoaplicado.pagamento.integracao

import br.com.projetoaplicado.pagamento.dominio.Pagamento
import br.com.projetoaplicado.pagamento.dominio.braspag.BrasPagCartao
import br.com.projetoaplicado.pagamento.dominio.braspag.Costumer
import br.com.projetoaplicado.pagamento.dominio.braspag.CreditCard
import br.com.projetoaplicado.pagamento.dominio.braspag.Payment
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
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

    fun pagarCartaoCredito(pagamento: Pagamento) {
        val cartao = pagamento.cartao
        var costomer = Costumer(pagamento.idAluno as String)
        var creditCard = CreditCard(cartao?.numero as Long, cartao?.nome as String, cartao?.vencimento as String, cartao.codigoSeguranca as Int, cartao.bandeira as String)
        var payment = Payment(Provider = "Simulado", Type = "CreditCard", Amount = pagamento?.valor as Double, CreditCard = creditCard)
        val brasPagCartao = BrasPagCartao(pagamento.idAgendamento as String, costomer, payment)
        val entity = HttpEntity(brasPagCartao, createHeader())
        val map = restTemplate.exchange("${urlBrasPag}v2/sales", HttpMethod.POST, entity, Any::class.java)
    }

    fun createHeader(): HttpHeaders {
        val headers = HttpHeaders()
        headers.set("MerchantId", merchantId)
        headers.set("MerchantKey", merchantKey)
        headers.set("RequestId", "1")
        headers.set("Content-Type", "application/json")
        return headers
    }



}