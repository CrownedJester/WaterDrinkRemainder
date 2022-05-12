package com.crownedjester.soft.waterdrinkremainder.presentation.util

object Formats {

    fun Int.toSeparatedDecimalString(textBefore: String="", textAfter: String=""): String {
        return "$textBefore%,d$textAfter".format(this)
    }
}