package com.fuck.viewtest.coroutine

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fuck.viewtest.R
import kotlinx.android.synthetic.main.activity_coroutine.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoroutineAty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)
        initUI()
    }


    private fun initUI() {
        btn_start_coroutine_global.setOnClickListener {
            startGlobalScopeCoroutine()
        }
        btn_start_coroutine_global2.setOnClickListener {
            startGlobalScopeCoroutine2()
        }

    }

    private fun startGlobalScopeCoroutine() {
        GlobalScope.launch { // 在后台启动一个新的协程并继续
            delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
            println("World!") // 在延迟后打印输出
        }
        println("Hello,") // 协程已在等待时主线程还在继续
    }

    private fun startGlobalScopeCoroutine2() {
        Thread{
            runBlocking {

            }
            GlobalScope.launch {
                delay(1000L)
                println("World!")
            }
            println("Hello,")
        }.start()
    }

}