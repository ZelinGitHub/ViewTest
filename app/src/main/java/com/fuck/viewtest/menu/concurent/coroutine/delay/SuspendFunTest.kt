package com.fuck.viewtest.menu.concurent.coroutine.delay

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun testSuspendFunNoDelay() {
    GlobalScope.launch {
        fuck()
    }
    println("Hello,")
}
fun testSuspendFunWithDelay() {
    GlobalScope.launch {
        suck()
    }
    println("Hello,")
}
//当协程体不含有挂起操作时，suspend可以省略
suspend fun fuck() {
    println("World!")
}
//当协程体含有挂起操作时，suspend不能省略
suspend fun suck() {
    delay(1000L)
    println("World!")
}


//没有挂起操作，也没有调用其他挂起函数，可以声明为挂起函数
//suspend可以省略，省略之后不再是挂起函数
private suspend fun like() {
    println("World!")
}
//含有使协程挂起的操作，必须声明为挂起函数
private suspend fun fight() {
    delay(1000L)
    println("World!")
}


//调用其他挂起函数，必须声明为挂起函数
private suspend fun kick(){
    fight()
}
//调用其他挂起函数，必须声明为挂起函数
private suspend fun lick(){
    like()
}

