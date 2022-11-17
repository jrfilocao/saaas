package com.saaas.app.resources

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc

private const val MESSAGE = "When I said how stupid can %s be? It was not a challenge."
private const val SALUTATION = "Love, %s"
private const val REQUEST_PATH = "/challenge/{name}/{from}"
private const val FROM_VALUE = "userName"
private const val NAME_VALUE = "name"

@WebMvcTest
class ChallengeResourceTest(@Autowired val mockMvc: MockMvc) {

    private val formattedSalutation = SALUTATION.format(FROM_VALUE)
    private val formattedMessage = MESSAGE.format(NAME_VALUE)

    @Test
    fun whenAcceptingPlainText_ThenReturnPlainText() {
        performGetAndExpectPlainText(mockMvc, REQUEST_PATH, formattedMessage, formattedSalutation, NAME_VALUE, FROM_VALUE)
    }

    @Test
    fun whenAcceptingJson_ThenReturnJson() {
        performGetAndExpectJson(mockMvc, REQUEST_PATH, formattedMessage, formattedSalutation, NAME_VALUE, FROM_VALUE)
    }

    @Test
    fun whenAcceptingXML_ThenReturnXML() {
        performGetAndExpectXML(mockMvc, REQUEST_PATH, formattedMessage, formattedSalutation, NAME_VALUE, FROM_VALUE)
    }

    @Test
    fun whenAcceptingHTML_ThenReturnHTML() {
        performGetAndExpectHTML(mockMvc, REQUEST_PATH, formattedMessage, formattedSalutation, NAME_VALUE, FROM_VALUE)
    }
}