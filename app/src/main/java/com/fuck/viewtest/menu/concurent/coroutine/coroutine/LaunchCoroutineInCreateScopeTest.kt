package com.fuck.viewtest.menu.concurent.coroutine.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun startScopeCoroutineOnNewScope() {
    runBlocking {
        //创建一个新的CoroutineScope
        //不过这种方法结构上不安全， 因为你不能再控制该方法执行的作用域
        val coroutineScope = CoroutineScope(kotlin.coroutines.coroutineContext)
        //使用新的CoroutineScope实例，调用launch方法
        coroutineScope.launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
    }
}
