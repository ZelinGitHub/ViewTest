package com.fuck.viewtest.menu.concurent.coroutine

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

var mCoroutineScope: CoroutineScope? = null

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
        mCoroutineScope = this
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
    val coroutineScope = CoroutineScope(coroutineContext)
    coroutineScope.launch { // 在 runBlocking 作用域中启动一个新协程
        delay(1000L)
        println("World!")
    }
    println("Hello,")
}


