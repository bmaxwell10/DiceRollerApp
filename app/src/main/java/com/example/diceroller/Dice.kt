package com.example.diceroller

class Dice(private val sides: Int) {

    fun roll(): Int { // method to roll dice that returns an integer value
        return (1..sides).random()
    }
}