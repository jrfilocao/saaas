package com.saaas.app.resources

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc

private const val MESSAGE = "I would like to confirm that I do not care about your request."
private const val SALUTATION = "Love, Server"
private const val REQUEST_PATH = "/not-found"

@WebMvcTest
class NotFoundResourceTest(@Autowired val mockMvc: MockMvc) {

    @Test
    fun whenAcceptingPlainText_ThenReturnPlainText() {
        performGetAndExpectPlainText(mockMvc, REQUEST_PATH, MESSAGE, SALUTATION)
    }

    @Test
    fun whenAcceptingJson_ThenReturnJson() {
        performGetAndExpectJson(mockMvc, REQUEST_PATH, MESSAGE, SALUTATION)
    }

    @Test
    fun whenAcceptingXML_ThenReturnXML() {
        performGetAndExpectXML(mockMvc, REQUEST_PATH, MESSAGE, SALUTATION)
    }

    @Test
    fun whenAcceptingHTML_ThenReturnHTML() {
        performGetAndExpectHTML(mockMvc, REQUEST_PATH, MESSAGE, SALUTATION)
    }
}