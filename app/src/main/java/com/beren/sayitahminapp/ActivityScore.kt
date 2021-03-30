package com.beren.sayitahminapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ActivityScore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        val result: String? = intent.getStringExtra("score")
        val fail: String? = intent.getStringExtra("fail")
        val number: String? = intent.getStringExtra("randomNumber")
        val resultTextView: TextView = findViewById(R.id.TextViewResult)
        val messageTextView: TextView = findViewById(R.id.textView)
        val imageView: ImageView = findViewById(R.id.imageView)
        if(fail=="failed"){
            resultTextView.text = "Tutulan sayı: $number"
            messageTextView.text = "ÜZGÜNÜM BİLEMEDİN"
            imageView.setBackgroundResource(R.drawable.confused);
        }else{
            resultTextView.text = "SKORUN: $result"
            messageTextView.text = "TEBRİKLER BİLDİN"
            imageView.setBackgroundResource(R.drawable.cheeky);
        }

        val buttonPlayAgain: TextView = findViewById(R.id.buttonResult)

        buttonPlayAgain.setOnClickListener {
            val intent = Intent(this@ActivityScore,MainActivity::class.java)
            startActivity(intent)
        }
    }
}