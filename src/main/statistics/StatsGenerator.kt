package main.statistics

interface StatsGenerator<T>{
    fun generateStats(data: List<T> )
}

