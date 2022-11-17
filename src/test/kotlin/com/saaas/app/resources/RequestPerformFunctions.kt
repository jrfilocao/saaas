package com.saaas.app.resources

import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

const val HTML_UTF8 = "text/html;charset=UTF-8"
private const val TEXT_PLAIN_UTF8 = "text/plain;charset=UTF-8"
private const val JSON_MESSAGE = "$.message"
private const val JSON_SALUTATION = "$.salutation"
private const val XML_MESSAGE = "/Content/message"
private const val XML_SALUTATION = "/Content/salutation"
private const val HTML_TITLE = "/html/head/title"
private const val HTML_MESSAGE = "/html/body/div/div/div/h1"
private const val HTML_SALUTATION = "/html/body/div/div/div/p/em"

fun performGetAndExpectPlainText(mockMvc: MockMvc, requestPath: String, message: String, salutation: String, vararg parameters: Any) {
    mockMvc.perform(
        MockMvcRequestBuilders.get(requestPath, *parameters)
        .accept(MediaType.TEXT_PLAIN))
        .andExpect(MockMvcResultMatchers.status().isOk)
        .andExpect(MockMvcResultMatchers.content().contentType(TEXT_PLAIN_UTF8))
        .andExpect(MockMvcResultMatchers.content().string("$message $salutation"));
}

fun performGetAndExpectJson(mockMvc: MockMvc, requestPath: String, message: String, salutation: String, vararg parameters: Any) {
    mockMvc.perform(
        MockMvcRequestBuilders.get(requestPath, *parameters)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk)
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.jsonPath(JSON_MESSAGE).value(message))
        .andExpect(MockMvcResultMatchers.jsonPath(JSON_SALUTATION).value(salutation));
}

fun performGetAndExpectXML(mockMvc: MockMvc, requestPath: String, message: String, salutation: String, vararg parameters: Any) {
    mockMvc.perform(
        MockMvcRequestBuilders.get(requestPath, *parameters)
        .accept(MediaType.APPLICATION_XML))
        .andExpect(MockMvcResultMatchers.status().isOk)
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_XML))
        .andExpect(MockMvcResultMatchers.xpath(XML_MESSAGE).string(message))
        .andExpect(MockMvcResultMatchers.xpath(XML_SALUTATION).string(salutation));
}

fun performGetAndExpectHTML(mockMvc: MockMvc, requestPath: String, message: String, salutation: String, vararg parameters: Any) {
    mockMvc.perform(
        MockMvcRequestBuilders.get(requestPath, *parameters).accept(MediaType.TEXT_HTML)
    )
        .andExpect(MockMvcResultMatchers.status().isOk)
        .andExpect(MockMvcResultMatchers.content().contentType(HTML_UTF8))
        .andExpect(MockMvcResultMatchers.xpath(HTML_TITLE).string("$message $salutation"))
        .andExpect(MockMvcResultMatchers.xpath(HTML_MESSAGE).string(message))
        .andExpect(MockMvcResultMatchers.xpath(HTML_SALUTATION).string(salutation));
}