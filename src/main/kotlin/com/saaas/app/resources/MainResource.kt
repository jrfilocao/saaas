package com.saaas.app.resources

import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

private const val MAIN_VIEW = "main"
private const val ROOT_PATH = "/"

@Controller
@RequestMapping(path = [ROOT_PATH])
class MainEndpoint {

    @GetMapping(produces = [MediaType.TEXT_HTML_VALUE])
    fun html(model: Model): String {
        return MAIN_VIEW
    }
}