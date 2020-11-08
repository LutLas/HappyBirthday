package io.erehsawsaltul.happybirthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // When button is pressed rollDice is executed
        findViewById<Button>(R.id.button).setOnClickListener {
            rollDice(6)
        }
        rollDice(1)
    }

    private fun rollDice(sides: Int) {
        // Update the screen with the dice roll & toast msg
        //Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
        //findViewById<TextView>(R.id.imageView).text = Dice(sides).roll().toString()
        val diceRolled = Dice(sides).roll()

        // Find the ImageView in the layout
        val diceImage = findViewById<ImageView>(R.id.imageView2)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRolled) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> 0
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRolled.toString()
    }



}