package com.saaas.app.resources

import com.saaas.app.resources.common.DynamicSalutationResource
import com.saaas.app.resources.common.ResourceConstants.DEFAULT_SALUTATION
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

private const val MESSAGE = "I would like to confirm that I do not care."
private const val REQUEST_PATH = "/confirmation/{from}"

@Controller
@RequestMapping(path = [REQUEST_PATH])
class ConfirmationResource : DynamicSalutationResource() {

    override fun getMessage(): String = MESSAGE
    override fun getSalutation(): String = DEFAULT_SALUTATION

}