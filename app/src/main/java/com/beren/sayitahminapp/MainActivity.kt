package com.beren.sayitahminapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.beren.sayitahminapp.databinding.ActivityMainBinding
import android.widget.Toast
import android.view.Gravity
import android.content.Intent

class MainActivity : AppCompatActivity() {
    val randomNumber = (1..100).random()
    var score =100


  private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonGuess.setOnClickListener {
                guessTheNumber()
        }
    }
    public fun guessTheNumber() {
        val number = binding.editTextGuess.text.toString()
        val infoText = binding.TextViewInfo
        val scoreText = binding.TextViewScore
        //Clearing the input box after every insertion
        binding.editTextGuess.setText("")
        // score decreasing for true result for every click on "Tahmin Et"
        score--
        if(number.toString().toIntOrNull() != null && number.toString().toIntOrNull() != null){
            if(number.toInt() in 1..100){
           if(score>0 ) {
               if (number.toInt() == randomNumber) {
                   score++
                   var intent = Intent(this, ActivityScore::class.java)
                   intent.putExtra("score", score.toString())
                   intent.putExtra("randomNumber", randomNumber.toString())
                   startActivity(intent)
               } else if (number.toInt() < randomNumber) {
                    if(randomNumber-number.toInt() in 51..99) {

                        infoText.text = "Daha büyük bir sayı gir"
                        Toast.makeText(applicationContext,"Oldukça uzaksın",Toast.LENGTH_SHORT).show()
                        scoreText.text = "$score deneme hakkın kaldı!"
                    }
                   else if (randomNumber-number.toInt() in 31..50){
                        infoText.text = "Daha büyük bir sayı gir"
                        Toast.makeText(applicationContext,"Uzaksın",Toast.LENGTH_SHORT).show()
                        scoreText.text = "$score deneme hakkın kaldı!"
                   }
                    else if (randomNumber-number.toInt() in 11..30) {
                        infoText.text = "Daha büyük bir sayı gir"
                        Toast.makeText(applicationContext,"Yakınsın",Toast.LENGTH_SHORT).show()
                        scoreText.text = "$score deneme hakkın kaldı!"
                    }
                    else if (randomNumber-number.toInt() <= 10) {
                        infoText.text = "Daha büyük bir sayı gir"
                        Toast.makeText(applicationContext,"Oldukça Yakınsın",Toast.LENGTH_SHORT).show()
                        scoreText.text = "$score deneme hakkın kaldı!"
                    }

               } else if (number.toInt() > randomNumber) {
                   when {
                       number.toInt()-randomNumber in 51..99 -> {
                           infoText.text = "Daha küçük bir sayı gir"
                           scoreText.text = "$score"
                           Toast.makeText(applicationContext,"Oldukça Uzaksın",Toast.LENGTH_SHORT).show()
                       }
                       number.toInt()-randomNumber in 31..50 -> {
                           infoText.text = "Daha küçük bir sayı gir"
                           Toast.makeText(applicationContext,"Uzaksın",Toast.LENGTH_SHORT).show()
                           scoreText.text = "$score deneme hakkın kaldı!"
                       }
                       number.toInt()-randomNumber in 11..30 -> {
                           infoText.text = "Daha küçük bir sayı gir"
                           Toast.makeText(applicationContext,"Yakınsın",Toast.LENGTH_SHORT).show()
                           scoreText.text = "$score deneme hakkın kaldı!"
                       }
                       number.toInt()-randomNumber <= 10 -> {
                           infoText.text = "Daha küçük bir sayı gir"
                           Toast.makeText(applicationContext,"Oldukça Yakınsın",Toast.LENGTH_SHORT).show()
                           scoreText.text = "$score deneme hakkın kaldı!"
                       }
                   }
               }
           }
        else{
               var fail ="failed"
               var intent = Intent(this, ActivityScore::class.java)
               intent.putExtra("fail", fail)
               intent.putExtra("randomNumber", randomNumber.toString())
               startActivity(intent)
           }
        }
           else{
               Toast.makeText(applicationContext,"1 ile 100 arasında bir sayı gir",Toast.LENGTH_SHORT).show()
           }
        }
        else{
            Toast.makeText(applicationContext,"Lütfen bir sayı gir",Toast.LENGTH_SHORT).show()
        }
}}





