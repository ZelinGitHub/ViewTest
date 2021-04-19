package com.fuck.viewtest.menu.concurent.coroutine

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
public fun fuckCoroutineStart() {
    val start1: CoroutineStart = CoroutineStart.DEFAULT
    val start2: CoroutineStart = CoroutineStart.LAZY
    val start3: CoroutineStart = CoroutineStart.ATOMIC
    val start4: CoroutineStart = CoroutineStart.UNDISPATCHED
}