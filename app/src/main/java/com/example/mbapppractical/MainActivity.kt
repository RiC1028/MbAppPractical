package com.example.mbapppractical

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.InputEvent
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var diceImg: ImageView
    lateinit var numbText: TextView
    lateinit var playerName: TextView
    lateinit var editPlayerName: EditText
    //var diceImg: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImg = findViewById(R.id.diceImage)
        numbText = findViewById(R.id.numbText)
        playerName = findViewById(R.id.playerName)
        editPlayerName = findViewById(R.id.editPlayerName)
        val updateBtn: Button = findViewById(R.id.renameBtn)
        updateBtn.setOnClickListener{updatePlayerName(editPlayerName)}
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
    private fun updatePlayerName(view: View){
        playerName.text = editPlayerName.text
        editPlayerName.text.clear()
        editPlayerName.clearFocus()

        //Hide keyboard after update player name
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}