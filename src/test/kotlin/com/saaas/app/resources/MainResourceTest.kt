package com.saaas.app.resources

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

private const val REQUEST_PATH = "/"

@WebMvcTest
class MainResourceTest(@Autowired val mockMvc: MockMvc) {

    @Test
    fun whenAcceptingHTML_ThenReturnHTML() {
        mockMvc.perform(
            get(REQUEST_PATH).accept(MediaType.TEXT_HTML)
        )
            .andExpect(status().isOk)
            .andExpect(content().contentType(HTML_UTF8))
    }
}