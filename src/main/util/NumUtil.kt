package main.util


fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)

fun Int.isGreaterThan(number: Int): Boolean = this > number
private fun Int.isLessThan(number: Int): Boolean = this < number

fun generateRandomIntInRange(min: Int, max: Int) =
        min + (Math.random() * ((max - min) + 1)).toInt()

