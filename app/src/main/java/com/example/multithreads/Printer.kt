package com.example.multithreads

import android.widget.TextView

class Printer : Runnable {

    override fun run() {
        Thread.sleep(3000)
        val text = "Hello from thread ${Thread.currentThread().name}"

    }
}