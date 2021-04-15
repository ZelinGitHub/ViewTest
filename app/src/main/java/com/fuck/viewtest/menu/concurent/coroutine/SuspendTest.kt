package com.fuck.viewtest.menu.concurent.coroutine

private suspend fun fuck2() {
    println("World!")
}

private suspend fun lick() {
    fuck2()
}