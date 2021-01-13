package com.fuck.viewtest.menu.okhttp

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.util.concurrent.TimeUnit

fun test() {
    val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    val requestGet = Request.Builder()
            .url("https://www.baidu.com")
            .build()

    val stringRequestBody = "请求体".toRequestBody("application/json;charset=utf-8".toMediaType())
    val requestPost = Request.Builder()
            .url("https://www.baidu.com")
            .post(stringRequestBody)
            .build()


    val call = okHttpClient.newCall(requestGet)

    val responseSync = call.execute()

    val responseAsync = call.enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
        }

        override fun onResponse(call: Call, response: Response) {
        }

    })

}
