package com.saaas.app.resources

import com.saaas.app.resources.common.DynamicSalutationResource
import com.saaas.app.resources.common.ResourceConstants.DEFAULT_SALUTATION
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

private const val MESSAGE = "Goodbye and please forget I exist."
private const val REQUEST_PATH = "/bye/{from}"

@Controller
@RequestMapping(path = [REQUEST_PATH])
class ByeResource : DynamicSalutationResource() {

    override fun getMessage(): String = MESSAGE
    override fun getSalutation(): String = DEFAULT_SALUTATION

}