package com.crownedjester.soft.waterdrinkremainder.presentation.util

object Formats {

    fun Int.toSeparatedDecimalString(textBefore: String = "", textAfter: String = ""): String =
        "$textBefore%,d$textAfter".format(this)


    fun calculateProgress(value: Int, goal: Int): Float =
        if (value > goal) {
            1f
        } else
            value.toFloat() / goal

    fun calculateRemaining(value: Int, goal: Int): Int =
        if (value > goal)
            0
        else
            goal - value

    fun String.hidePass(): String {
        var hiddenString = ""

        repeat(this.length) {
            hiddenString += '*'
        }

        return hiddenString
    }

    fun String.trimC(): String {
        var trimString = ""

        this.forEach {
            if (it != ' ') {
                trimString += it
            }
        }

        return trimString

    }
}