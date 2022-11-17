package com.saaas.app.resources

import com.saaas.app.resources.common.changeModelAndGetView
import com.saaas.app.resources.common.getPlainText
import com.saaas.app.response.Content
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

private const val MESSAGE = "I would like to confirm that I do not care about your request."
private const val SALUTATION = "Love, Server"
private const val REQUEST_PATH = "/not-found"

@Controller
@RequestMapping(REQUEST_PATH)
class NotFoundResource {

    @GetMapping(produces = [MediaType.TEXT_HTML_VALUE])
    fun html(model: Model): String = changeModelAndGetView(MESSAGE, SALUTATION, model)

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    @ResponseBody
    fun jsonXml(): Content = Content(MESSAGE, SALUTATION)

    @GetMapping(produces = [MediaType.TEXT_PLAIN_VALUE])
    @ResponseBody
    fun plainText(): String = getPlainText(MESSAGE, SALUTATION)
}