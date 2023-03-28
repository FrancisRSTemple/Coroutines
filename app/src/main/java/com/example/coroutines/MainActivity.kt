package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val timerTextView: TextView by lazy {
        findViewById(R.id.timerTextView)
    }

    val timerButton: Button by lazy {
        findViewById(R.id.startTimerButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timerButton.setOnClickListener{
            CoroutineScope(Job() + Dispatchers.Default).launch {
                textViewTimerUpdate()
            }
        }
    }

    suspend fun textViewTimerUpdate(){
        for(i in 100 downTo 1){
            withContext(Dispatchers.Main){
                timerTextView.text = i.toString()
            }
            delay(1000)
        }
    }
}