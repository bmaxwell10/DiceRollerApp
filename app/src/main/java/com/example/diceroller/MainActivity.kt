package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
/*
Summary:
- Classes and object instances in Kotlin
- Create an interactive Dice Roller app
- Add conditional behavior in Kotlin
- Add images to the Dice Roller app
- Write unit tests
- Intro to debugging
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.button)

        // Set a click listener on the button to roll the
        // dice when the user taps the button
        rollButton.setOnClickListener {

            // Do a dice roll when app starts
            rollDice()

            /*

            // Set the value displayed by a TextView
             val resultTextView: TextView = findViewById(R.id.textView)
              resultTextView.text = "6"

            // Display a Toast message
                  Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()

               */
        }
    }

    private fun rollDice() { // Roll the dice and update the screen with the result.

        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll() // roll dice object and save result as #

        // Update screen # with dice roll
        val resultTextView: TextView = findViewById(R.id.textView) // find TextView
        resultTextView.text = diceRoll.toString()  // convert diceRoll # to a string
        // and update resultTextView

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        /* // Less optimal version of code to change the drawable image based on the
           // dice # rolled
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
         */



        // Update the content description
        diceImage.contentDescription = diceRoll.toString() // allows dice # rolled to be read aloud

    }
}