package com.saaas.app.response

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement
data class Content(val message: String, val salutation: String)