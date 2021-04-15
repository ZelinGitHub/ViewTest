package com.fuck.viewtest.menu.concurent.coroutine

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.fuck.viewtest.R
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

class CoroutineAty : AppCompatActivity() {
    private lateinit var btn_test_coroutine: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)
        initViews()
        initUI()
    }

    private fun initViews() {
        btn_test_coroutine = findViewById<Button>(R.id.btn_test_coroutine)
    }


    private fun initUI() {
        btn_test_coroutine.setOnClickListener {
        }
    }



}