package br.com.pocws.kotlinclientws.infra.wsclient

import br.com.pocws.kotlinclientws.artifacts.NumberConversionSoapType
import br.com.pocws.kotlinclientws.artifacts.NumberToWords
import br.com.pocws.kotlinclientws.artifacts.NumberToWordsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import org.springframework.ws.client.core.WebServiceTemplate
import org.springframework.ws.soap.client.core.SoapActionCallback
import java.net.URL
import javax.xml.namespace.QName

@Service
class NumberWSClient(private val webServiceTemplate: WebServiceTemplate) {

    suspend fun numberToWordsResponse(number: Int): String = withContext(Dispatchers.IO) {
        val urlService = URL("https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL")
        val qName = QName("http://www.dataaccess.com/webservicesserver/", "NumberConversion")
        val service = jakarta.xml.ws.Service.create(urlService, qName)

        val numberConversionSoapType = service.getPort(NumberConversionSoapType::class.java)
        numberConversionSoapType.numberToWords(number.toBigInteger())
    }

    fun numberToWordsResponseKotlin(number: Int): String {
        val request = NumberToWords().apply {
            ubiNum = number.toBigInteger()
        }

        val respose = webServiceTemplate.marshalSendAndReceive(
            "https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL",
            request,
            SoapActionCallback("https://www.dataaccess.com/webservicesserver/numberconversion.wso")
        ) as NumberToWordsResponse

        return respose.numberToWordsResult
    }
}