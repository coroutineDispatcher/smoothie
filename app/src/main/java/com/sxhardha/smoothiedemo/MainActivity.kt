package com.sxhardha.smoothiedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sxhardha.smoothie.Smoothie
import com.sxhardha.smoothie.SmoothieThermometer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSmoothie.setOnClickListener {
            Smoothie.increment()
            GlobalScope.launch(Dispatchers.IO) {
                delay(5000)
                withContext(Dispatchers.Main) {
                    Smoothie.decrement()
                    tvSmoothie.text = "HELLO SMOOTHIE!"
                }
            }
        }
    }
}