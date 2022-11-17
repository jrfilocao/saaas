package com.saaas.app.resources

import com.saaas.app.resources.common.DynamicMessageAndSalutationResource
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

private const val MESSAGE = "Hi {0}, I am busy right now, can I ignore you some other time?"
private const val SALUTATION = "Best, {0}"
private const val REQUEST_PATH = "/busy/{name}/{from}"

@Controller
@RequestMapping(path = [REQUEST_PATH])
class BusyResource : DynamicMessageAndSalutationResource() {

    override fun getMessage(): String = MESSAGE
    override fun getSalutation(): String = SALUTATION
}