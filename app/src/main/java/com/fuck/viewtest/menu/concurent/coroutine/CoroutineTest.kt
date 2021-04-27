package com.fuck.viewtest.menu.concurent.coroutine


import com.fuck.viewtest.menu.concurent.coroutine.cancel.testDelayCancelInBlockingCoroutineOnParamScope
import com.fuck.viewtest.menu.concurent.coroutine.exception.testExceptionOnGlobalScope
import com.fuck.viewtest.menu.concurent.coroutine.exception.testExceptionOnParamScope
import com.fuck.viewtest.menu.concurent.coroutine.exception.testExceptionOnParamScopeTwoCoroutine
import com.fuck.viewtest.menu.concurent.coroutine.scope.normalcoroutine.*
import com.fuck.viewtest.menu.concurent.coroutine.scopecoroutine.startNestScopeCoroutineInCoroutine
import com.fuck.viewtest.menu.concurent.coroutine.scopecoroutine.startScopeCoroutineInCoroutine
import com.fuck.viewtest.menu.concurent.coroutine.scopecoroutine.startTimeoutCoroutineInCoroutine
import com.fuck.viewtest.menu.concurent.coroutine.scopecoroutine.startTwoScopeCoroutineInCoroutine


fun testCoroutine(){
    testExceptionOnParamScopeTwoCoroutine()
}