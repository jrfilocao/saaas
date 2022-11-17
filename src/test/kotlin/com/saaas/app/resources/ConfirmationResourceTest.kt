package com.saaas.app.resources

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc

private const val MESSAGE = "I would like to confirm that I do not care."
private const val REQUEST_PATH = "/confirmation/{from}"
private const val SALUTATION = "Best, %s"
private const val FROM_VALUE = "userName"

@WebMvcTest
class ConfirmationResourceTest(@Autowired val mockMvc: MockMvc) {

    private val formattedSalutation = SALUTATION.format(FROM_VALUE)

    @Test
    fun whenAcceptingPlainText_ThenReturnPlainText() {
        performGetAndExpectPlainText(mockMvc, REQUEST_PATH, MESSAGE, formattedSalutation, FROM_VALUE)
    }

    @Test
    fun whenAcceptingJson_ThenReturnJson() {
        performGetAndExpectJson(mockMvc, REQUEST_PATH, MESSAGE, formattedSalutation, FROM_VALUE)
    }

    @Test
    fun whenAcceptingXML_ThenReturnXML() {
        performGetAndExpectXML(mockMvc, REQUEST_PATH, MESSAGE, formattedSalutation, FROM_VALUE)
    }

    @Test
    fun whenAcceptingHTML_ThenReturnHTML() {
        performGetAndExpectHTML(mockMvc, REQUEST_PATH, MESSAGE, formattedSalutation, FROM_VALUE)
    }
}