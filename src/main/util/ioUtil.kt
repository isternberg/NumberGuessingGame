package main.util

val NOT_A_NUMBER_MSG = "Input is not a number"
val PLS_ENTER_VALUE = "Please enter the first number:"
val INVALID_INPUT_MSG = "Invalid Input."
val INPUT_OUT_OF_RANGE_MSG = "Input out of range. "

fun getValidNumberFromUser(prompt:String=PLS_ENTER_VALUE): Int {
    var validInput = false
    var number: Int = -1
    while (!validInput) {
        println(prompt)
        val input: String? = readLine()
        if (input != null) {
            try {
                number = input.toInt()
                validInput = true
            } catch(e: NumberFormatException) {
                println(NOT_A_NUMBER_MSG)
            }
        }
    }
    return number
}


fun getValidNumberGreaterThanFromUser(min:Int): Int {
    var number: Int = -1
    var inputIsGreaterThanMin = false
    while (!inputIsGreaterThanMin) {
        number = getValidNumberFromUser("Please enter a number greater than $min:")
        if (number.isGreaterThan(min)) {
            inputIsGreaterThanMin = true
        } else {
            print(INVALID_INPUT_MSG)
        }
    }
    return number
}


fun getValidNumberInRangeFromUser(min:Int, max:Int): Int {
    var number: Int = -1
    var inputIsInRange = false
    val isNumberInRange:(Int,Int,Int)->Boolean = { num,min,max -> num >= min && num <= max }
    while (!inputIsInRange) {
        number = getValidNumberFromUser("Please enter a number in the range [$min-$max]:")
        if (isNumberInRange(number, min, max)) {
            inputIsInRange = true
        } else {
            print(INPUT_OUT_OF_RANGE_MSG)
        }
    }
    return number
}