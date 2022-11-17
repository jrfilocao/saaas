package com.saaas.app.resources.common

import com.saaas.app.response.Content
import org.springframework.ui.Model
import org.springframework.ui.set
import java.text.MessageFormat

private const val TITLE_PROPERTY = "message"
private const val SUBTITLE_PROPERTY = "salutation"
private const val WHOLE_TEXT_PROPERTY = "wholeText"
private const val RESOURCE_VIEW = "resource"

fun changeModelAndGetView(message: String, salutation: String, model: Model): String {
    model[TITLE_PROPERTY] = message
    model[SUBTITLE_PROPERTY] = salutation
    model[WHOLE_TEXT_PROPERTY] = "$message $salutation"
    return RESOURCE_VIEW
}

fun getContent(message: String, salutation: String) : Content = Content(message, salutation)

fun getPlainText(message: String, salutation: String) : String = "$message $salutation"

fun formatText(text: String, vararg arguments: String): String = MessageFormat.format(text, *arguments)

