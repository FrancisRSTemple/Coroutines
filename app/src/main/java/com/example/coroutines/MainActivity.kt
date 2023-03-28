package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val timerHandler = Handler(Looper.getMainLooper()){

        timerTextView.text = it.what.toString()

        true
    }

    val timerTextView: TextView by lazy {
        findViewById(R.id.timerTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread{
            for(i in 100 downTo 1){
                Log.d("Countdown", i.toString())
                Thread.sleep(1000)

                timerHandler.sendEmptyMessage(i)

                /*
                //this stuff isn't necessary if we're only sending 1 piece of data
                //in the what variable
                val msg = Message.obtain()

                msg.what = i

                timerHandler.sendMessage(msg)
                 */
            }
        }.start()

    }
}