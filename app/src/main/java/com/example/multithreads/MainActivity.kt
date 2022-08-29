package com.example.multithreads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.concurrent.ConcurrentHashMap
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnStart).setOnClickListener {
        }
    }


    //Меняем UI с помощью Handler
    fun changeUItextByHandler(){
        val thread1 = Thread{
            Thread.sleep(3000)

            val handler: Handler = Handler(Looper.getMainLooper())
            handler.post {
                findViewById<TextView>(R.id.tvField).setText("Hello from thread ${Thread.currentThread().name}")
            }

        }
        thread1.start()
    }

    //передаем задачи в MainThread с помощью runOnUiThread

    fun changeUiRunOnUiThread(){

        val thread = Thread{
            Thread.sleep(3000)
            val text = "Hello from ${Thread.currentThread().name}"
            runOnUiThread {
                findViewById<TextView>(R.id.tvField).setText(text)
            }
        }

        thread.start()

    }



}