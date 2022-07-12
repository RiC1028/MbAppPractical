package com.example.mbapppractical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var diceImg: ImageView
    lateinit var numbText: TextView
    //var diceImg: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImg = findViewById(R.id.diceImage)
        numbText = findViewById(R.id.numbText)
        val rollBtn: Button = findViewById(R.id.rollButton)
        rollBtn.setOnClickListener{(rollDice())}
    }
    private fun rollDice(){
        val randNum = (1..6).random()
        //val numbText: TextView = findViewById(R.id.numbText)
        numbText.text = randNum.toString()
        //val diceImg: ImageView = findViewById(R.id.diceImage)
        val imgSrc = when(randNum){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImg.setImageResource(imgSrc)
        Toast.makeText(this, randNum.toString(), Toast.LENGTH_SHORT).show()
    }
}