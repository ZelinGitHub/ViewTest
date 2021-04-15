package com.fuck.viewtest.menu.concurent.coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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