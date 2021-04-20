package com.fuck.viewtest.menu.concurent.coroutine.scope

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

fun testCoroutineScope() {


    val coroutineScope: CoroutineScope? = null


    runBlocking {
        val contextScope: CoroutineScope = CoroutineScope(kotlin.coroutines.coroutineContext)
    }

    GlobalScope

}