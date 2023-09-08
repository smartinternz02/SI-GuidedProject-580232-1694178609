package main.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButtonMA: Button = findViewById(R.id.rollbutton)
        rollButtonMA.setOnClickListener {
            RollDice()

            val toastMA = Toast.makeText(this, "Dice rolled!", Toast.LENGTH_LONG)
            toastMA.show()

        }
    }

    fun RollDice() {
        val textViewMA: TextView = findViewById(R.id.randNumber)
        textViewMA.textSize = 30f
        val num: Int = Random.nextInt(1,7)
        textViewMA.text = num.toString()

        val ImgViewMA: ImageView = findViewById(R.id.diceView)
        ImgViewMA.maxHeight = 142
        ImgViewMA.maxWidth = 150

        when (num) {
            1 -> ImgViewMA.setImageResource(R.drawable.d1)
            2 -> ImgViewMA.setImageResource(R.drawable.d2)
            3 -> ImgViewMA.setImageResource(R.drawable.d3)
            4 -> ImgViewMA.setImageResource(R.drawable.d4)
            5 -> ImgViewMA.setImageResource(R.drawable.d5)
            6 -> ImgViewMA.setImageResource(R.drawable.d6)
            else -> ImgViewMA.setImageResource(R.drawable.d6)
        }
    }

}