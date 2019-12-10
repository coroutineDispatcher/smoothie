package com.sxhardha.smoothiedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sxhardha.smoothie.Smoothie
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSmoothie.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                Smoothie.startProcess()
                delay(5000)
                withContext(Dispatchers.Main) {
                    tvSmoothie.text = "HELLO SMOOTHIE!"
                    Smoothie.endProcess()
                }
            }
        }
    }
}