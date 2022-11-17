package com.saaas.app.resources

import com.saaas.app.resources.common.DynamicSalutationResource
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

private const val MESSAGE = "Not sure if I miss you or I miss insulting you."
private const val SALUTATION = "Love, {0}"
private const val REQUEST_PATH = "/missing/{from}"

@Controller
@RequestMapping(path = [REQUEST_PATH])
class MissingResource : DynamicSalutationResource() {

    override fun getMessage(): String = MESSAGE
    override fun getSalutation(): String = SALUTATION

}