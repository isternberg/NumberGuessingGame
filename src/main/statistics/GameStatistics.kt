package main.statistics
import main.util.format

object GameStatistics : StatsGenerator<Int>{
    override fun generateStats(data: List<Int>) {
        val toGuessNumber = data.get(0)
        val userInputs = data.subList(1, data.size)
        val greaterThanSecret: Int = userInputs.filter { it > toGuessNumber }.count()
        announceStats(userInputs, greaterThanSecret)

    }
    private fun announceStats(userInputs: List<Int>, greaterThanSecret:Int){
        val numberOfGuesses = userInputs.size
        val numberOfMisses = numberOfGuesses - 1
        val percentHigherMisses = greaterThanSecret.toDouble() / numberOfMisses * 100

        println("Your guesses were $userInputs")
        println("It took you $numberOfGuesses guesses to get it right.")
        println("${percentHigherMisses.format(2)}% of misses were greater than number.")
        println("${(100 - percentHigherMisses).format(2)}% of misses were less than number.")
    }

}
