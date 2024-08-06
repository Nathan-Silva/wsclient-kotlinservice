package br.com.pocws.kotlinclientws.infra.resource

import br.com.pocws.kotlinclientws.infra.wsclient.NumberWSClient
import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class NumberToWordsResource(private val numberWsClient: NumberWSClient) {

    @GetMapping("/java/{number}")
    fun getNumberToWords(@PathVariable("number") number: Int): String = runBlocking {
        numberWsClient.numberToWordsResponse(number)
    }

    @GetMapping("/kotlin/{number}")
    fun getNumberToWordsKotlin(@PathVariable("number") number: Int): String {
        return numberWsClient.numberToWordsResponseKotlin(number)
    }
}