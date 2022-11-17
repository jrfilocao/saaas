package com.saaas.app.resources

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc

private const val MESSAGE = "It's beginning to look a lot like fuck this."
private const val REQUEST_PATH = "/beginning/{from}"
private const val SALUTATION = "Best, %s"
private const val FROM_VALUE = "userName"

@WebMvcTest
class BeginningResourceTest(@Autowired val mockMvc: MockMvc) {

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