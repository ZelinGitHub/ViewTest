package com.fuck.viewtest.menu.coroutine

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fuck.viewtest.R
import kotlinx.android.synthetic.main.activity_coroutine.*
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

class CoroutineAty : AppCompatActivity() {
    var mCoroutineScope: CoroutineScope? = null
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
        runBlocking {
            GlobalScope.launch {
                delay(1000L)
                println("World!")
            }
            println("Hello,")
        }
    }

    private fun startGlobalScopeCoroutine3() {
        runBlocking {
            val job = GlobalScope.launch {
                delay(1000L)
                println("World!")
            }
            println("Hello,")
            job.join()
        }
    }

    private fun startGlobalScopeCoroutine4() {
        GlobalScope.launch {
            fuck()
        }
        println("Hello,")
    }


    private fun fuck() {
        println("World!")
    }

    private suspend fun fuck2() {
        println("World!")
    }

    private suspend fun lick() {
        fuck2()
    }

    private fun startGlobalScopeCoroutine5() {
        GlobalScope.launch {
            suck()
        }
        println("Hello,")
    }

    private suspend fun suck() {
        delay(1000L)
        println("World!")
    }

    private suspend fun kick() {
        suck()
    }


    private fun startScopeCoroutine() {
        runBlocking {
            launch {
                delay(1000L)
                println("World!")
            }
            println("Hello,")
        }
    }



    private fun startScopeCoroutine2() {
        runBlocking {
            sick()
        }
    }

    private fun CoroutineScope.sick() {
        launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
    }


    private fun startScopeCoroutine3() {
        runBlocking {
            mCoroutineScope=this
            sick2()
        }
    }

    private fun sick2() {
        mCoroutineScope?.launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
    }
    private fun startScopeCoroutine4() {
        runBlocking {
            sick3()
        }
    }

    private suspend fun sick3() {
        val coroutineScope= CoroutineScope(coroutineContext)
        coroutineScope.launch { // 在 runBlocking 作用域中启动一个新协程
            delay(1000L)
            println("World!")
        }
        println("Hello,")
    }

    private fun createCoroutineScope() {
        runBlocking {
            launch {
                delay(200L)
                println("协程 runBlocking launch")
            }
            coroutineScope {
                launch {
                    delay(500L)
                    println("协程 coroutineScope launch")
                }
                delay(100L)
                println("协程 CoroutineScope")
            }
            println("协程 runBlocking")
        }
    }
}