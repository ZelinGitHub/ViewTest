package com.fuck.viewtest.menu.concurent.coroutine.coroutine.normalcoroutine

import kotlinx.coroutines.*


fun startCoroutineInBlockingCoroutineOnParamScope() {
    Thread {
        println("thread begin")
        runBlocking {
            println("blocking coroutine begin")
            //使用runBlocking函数传入的CoroutineScope实例，调用launch方法
            this.launch {
                println("normal coroutine begin")
                delay(3000L)
                println("normal coroutine end")
            }
            delay(1000L)
            println("blocking coroutine end")
        }
        println("thread end")
    }.start()
}

fun startCoroutineInBlockingCoroutineOnParamScope2() {
    Thread {
        println("thread begin")
        runBlocking {
            println("blocking coroutine begin")
            //使用runBlocking函数传入的CoroutineScope实例，调用launch方法
            this.launch {
                println("normal coroutine begin")
                delay(1000L)
                println("normal coroutine end")
            }
            delay(3000L)
            println("blocking coroutine end")
        }
        println("thread end")
    }.start()
}


var mCoroutineScope: CoroutineScope? = null

//保存runBlocking的CoroutineScope实例
fun startBlockingCoroutineAndSaveParamScope() {
    Thread {
        println("thread begin")
        runBlocking {
            println("blocking coroutine begin")
            mCoroutineScope = this
            startCoroutineInBlockingCoroutineOnParamScope3()
            delay(1000L)
            println("blocking coroutine end")
        }
        println("thread end")
    }.start()
}

//使用runBlocking的CoroutineScope实例启动协程
fun startCoroutineInBlockingCoroutineOnParamScope3() {
    mCoroutineScope?.launch {
        println("normal coroutine begin")
        delay(3000L)
        println("normal coroutine end")
    }
}


fun startCoroutineInBlockingCoroutineOnNewScope() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块协程开始执行")
            val coroutineScope = CoroutineScope(kotlin.coroutines.coroutineContext)
            coroutineScope.launch {
                println("普通协程开始执行")
                delay(3000L)
                println("普通协程执行结束")
            }
            delay(1000L)
            println("阻塞块协程执行结束")
        }
        println("线程执行结束")
    }.start()
}


fun startCoroutineInBlockingCoroutineOnGlobalScope() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块协程开始执行")
            GlobalScope.launch {
                println("普通协程开始执行")
                delay(3000L)
                println("普通协程执行结束")
            }
            delay(1000L)
            println("阻塞块协程执行结束")
        }
        println("线程执行结束")
    }.start()
}


fun startDeferredCoroutineInBlockingOnGlobalScope() {
    Thread {
        println("线程 开始执行")
        runBlocking {
            println("阻塞块线程 开始执行")
            val deferred: Deferred<String> = GlobalScope.async {
                println("异步协程 开始执行")
                delay(3000L)
                println("异步协程 执行结束")
                "Death"
            }
            val result = deferred.await()
            println("阻塞块协程 异步协程的执行结果是 $result")
            println("阻塞块协程 执行结束")
        }
        println("线程 执行结束")
    }.start()
}

fun testCoroutineWeigh() {
    Thread {
        runBlocking {
            repeat(100_000) { // 启动大量的协程
                this.launch {
                    delay(5000L)
                    print(".")
                }
            }
        }
    }.start()
}


fun testCoroutineWeigh2() {
    Thread{
        println("线程 开始")
        runBlocking {
            println("阻塞块协程 开始")
            println("阻塞块协程 启动一百万个异步协程发起计算")
            //对区间的每个元素应用变换
            //1..1_000_000是一个区间
            val interval = (1..1_000_000).map { n ->
                //启动一个异步协程
                //变换结果是异步协程（Deferred）（把整数变换为协程）
                GlobalScope.async {
                    //计算结果是n，也就是把原数字返回
                    n
                }
            }
            println("阻塞块协程 尝试获取计算结果")
            //为每一个元素应用lambda，并求和
            val sum = interval.sumOf {
                //得到异步协程的计算结果
                val result = it.await()
                result.toLong()
            }
            println("阻塞块协程 计算结果：$sum")
            println("阻塞块协程 结束")
        }
        println("线程 结束")
    }.start()


}
