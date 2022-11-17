package com.saaas.app.resources

import com.saaas.app.resources.common.DynamicSalutationResource
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

private const val MESSAGE = "I am not sarcastic. I am just intelligent beyond your understanding."
private const val SALUTATION = "Love, {0}"
private const val REQUEST_PATH = "/sarcasm/{from}"

@Controller
@RequestMapping(path = [REQUEST_PATH])
class SarcasmResource : DynamicSalutationResource() {

    override fun getMessage(): String = MESSAGE
    override fun getSalutation(): String = SALUTATION
}