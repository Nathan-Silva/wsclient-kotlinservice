package br.com.pocws.kotlinclientws.infra.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.oxm.jaxb.Jaxb2Marshaller
import org.springframework.ws.client.core.WebServiceTemplate

@Configuration
class SoapClientConfig {

    @Bean(name = ["marshallerConfig"])
    fun marshaller(): Jaxb2Marshaller {
        val marshaller = Jaxb2Marshaller()
        marshaller.contextPath = "br.com.pocws.kotlinclientws"
        return marshaller
    }

    @Bean(name = ["webServiceTemplateConfig"])
    fun webServiceTemplate(jaxb2Marshaller: Jaxb2Marshaller): WebServiceTemplate {
        val webServiceTemplate = WebServiceTemplate()
        webServiceTemplate.marshaller = jaxb2Marshaller
        webServiceTemplate.unmarshaller = jaxb2Marshaller
        return webServiceTemplate
    }
}