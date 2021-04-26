package com.fuck.viewtest.menu.concurent.coroutine

import com.fuck.viewtest.menu.concurent.coroutine.coroutine.normalcoroutine.executeTwoComputeConcur
import com.fuck.viewtest.menu.concurent.coroutine.coroutine.normalcoroutine.executeTwoComputeConcurLazy
import com.fuck.viewtest.menu.concurent.coroutine.coroutine.normalcoroutine.executeTwoComputeNoConcur
import com.fuck.viewtest.menu.concurent.coroutine.coroutine.scopecoroutine.startNestScopeCoroutineInCoroutine
import com.fuck.viewtest.menu.concurent.coroutine.coroutine.scopecoroutine.startScopeCoroutineInCoroutine
import com.fuck.viewtest.menu.concurent.coroutine.coroutine.scopecoroutine.startTimeoutCoroutineInCoroutine
import com.fuck.viewtest.menu.concurent.coroutine.coroutine.scopecoroutine.startTwoScopeCoroutineInCoroutine


fun testCoroutine(){
    executeTwoComputeConcurLazy()
}