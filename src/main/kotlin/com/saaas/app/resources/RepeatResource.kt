package com.saaas.app.resources

import com.saaas.app.resources.common.DynamicSalutationResource
import com.saaas.app.resources.common.ResourceConstants.DEFAULT_SALUTATION
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

private const val MESSAGE = "No, you do not have to repeat yourself... I was ignoring you the first time."
private const val REQUEST_PATH = "/repeat/{from}"

@Controller
@RequestMapping(path = [REQUEST_PATH])
class RepeatResource : DynamicSalutationResource() {

    override fun getMessage(): String = MESSAGE
    override fun getSalutation(): String = DEFAULT_SALUTATION

}