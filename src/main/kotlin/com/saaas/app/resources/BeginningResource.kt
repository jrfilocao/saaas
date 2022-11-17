package com.saaas.app.resources

import com.saaas.app.resources.common.DynamicSalutationResource
import com.saaas.app.resources.common.ResourceConstants.DEFAULT_SALUTATION
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

private const val MESSAGE = "It's beginning to look a lot like fuck this."
private const val REQUEST_PATH = "/beginning/{from}"

@Controller
@RequestMapping(path = [REQUEST_PATH])
class BeginningResource : DynamicSalutationResource() {

    override fun getMessage(): String = MESSAGE
    override fun getSalutation(): String = DEFAULT_SALUTATION

}