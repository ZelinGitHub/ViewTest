package com.fuck.viewtest.menu.concurent.coroutine

import com.fuck.viewtest.menu.concurent.coroutine.cancel.*
import com.fuck.viewtest.menu.concurent.coroutine.coroutine.normalcoroutine.startCoroutineInBlockingCoroutineOnGlobalScope
import com.fuck.viewtest.menu.concurent.coroutine.coroutine.normalcoroutine.startCoroutineInBlockingCoroutineOnNewScope
import com.fuck.viewtest.menu.concurent.coroutine.coroutine.normalcoroutine.startCoroutineInBlockingCoroutineOnParamScope
import com.fuck.viewtest.menu.concurent.coroutine.coroutine.normalcoroutine.testCoroutineWeigh


fun testCoroutine(){
    testDelayCancelFinallyDelayWithContext()
}