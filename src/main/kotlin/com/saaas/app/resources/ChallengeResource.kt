package com.saaas.app.resources

import com.saaas.app.resources.common.DynamicMessageAndSalutationResource
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

private const val MESSAGE = "When I said how stupid can {0} be? It was not a challenge."
private const val SALUTATION = "Love, {0}"
private const val REQUEST_PATH = "/challenge/{name}/{from}"

@Controller
@RequestMapping(path = [REQUEST_PATH])
class ChallengeResource : DynamicMessageAndSalutationResource() {

    override fun getMessage(): String = MESSAGE
    override fun getSalutation(): String = SALUTATION
}