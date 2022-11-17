package com.saaas.app.resources

import com.saaas.app.resources.common.DynamicSalutationResource
import com.saaas.app.resources.common.ResourceConstants.DEFAULT_SALUTATION
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

private const val MESSAGE = "If I wanted to kill myself, I would climb your ego and jump to your IQ."
private const val REQUEST_PATH = "/suicide/{from}"

@Controller
@RequestMapping(path = [REQUEST_PATH])
class SuicideResource : DynamicSalutationResource(){

    override fun getMessage(): String = MESSAGE
    override fun getSalutation(): String = DEFAULT_SALUTATION

}