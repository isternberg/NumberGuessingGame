package main.game

import main.statistics.GameStatistics
import main.util.generateRandomIntInRange
import main.util.getValidNumberFromUser
import main.util.getValidNumberGreaterThanFromUser
import main.util.getValidNumberInRangeFromUser
import java.util.*

val GAME_INSTRUCTIONS = "Hi! In this game you'll try to guess a number in the range you define."
val FAILURE_MSG = "nope. Try again."
val IS_CORRECT = "is correct!"

fun main(args: Array<String>) {
    println(GAME_INSTRUCTIONS)
    var gameData: ArrayList<Int> = arrayListOf()
    val min = getValidNumberFromUser()
    val max = getValidNumberGreaterThanFromUser(min)
    var secret = generateRandomIntInRange(min, max)
    gameData.add(secret)
    var guessCorrect = false
    while (!guessCorrect) {
        var guessInput = getValidNumberInRangeFromUser(min, max)
        gameData.add(guessInput)
        if (guessInput == secret){
            println("$guessInput ${IS_CORRECT}")
            GameStatistics.generateStats(gameData)
            guessCorrect = true
        } else{
            println(FAILURE_MSG)
        }

    }

}








