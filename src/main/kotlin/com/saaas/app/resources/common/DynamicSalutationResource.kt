package com.saaas.app.resources.common

import com.saaas.app.response.Content
import org.springframework.http.MediaType
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody

abstract class DynamicSalutationResource : Resource {

    @GetMapping(produces = [MediaType.TEXT_HTML_VALUE])
    fun html(@PathVariable from: String, model: Model): String = changeModelAndGetView(getMessage(), getDynamicSalutation(from), model)

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    @ResponseBody
    fun jsonXml(@PathVariable from: String): Content = getContent(getMessage(), getDynamicSalutation(from))

    @GetMapping(produces = [MediaType.TEXT_PLAIN_VALUE])
    @ResponseBody
    fun plainText(@PathVariable from: String): String = getPlainText(getMessage(), getDynamicSalutation(from))

    private fun getDynamicSalutation(from: String): String = formatText(getSalutation(), from)

}