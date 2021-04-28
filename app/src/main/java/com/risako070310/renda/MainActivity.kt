package com.risako070310.renda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count = 0
    var time = 10

    val timer:CountDownTimer = object:CountDownTimer(10000,1000){
        override fun onFinish() {
            startButton.isVisible = true
            tapButton.setBackgroundResource(R.drawable.background_circle_gray)
            time = 10
            count = 0
        }

        override fun onTick(millisUntilFinished: Long) {
            tapButton.setBackgroundResource(R.drawable.background_circle)
            time -= 1
            timeText.text = time.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener{
            countText.text = count.toString()
            startButton.isVisible = false
            timer.start()
        }

        tapButton.setOnClickListener{
            if(time < 10) {
                count += 1
                countText.text = count.toString()
            }
        }
    }
}