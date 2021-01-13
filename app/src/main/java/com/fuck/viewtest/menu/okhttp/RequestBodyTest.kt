package com.fuck.viewtest.menu.okhttp

import okhttp3.FormBody
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okio.BufferedSink
import java.io.File


fun createRequestBody1() {
    val stringRequestBody = "请求体".toRequestBody(
            "application/json;charset=utf-8".toMediaType()
    )

    val file = File("/fileName")
    val fileRequestBody: RequestBody = file.asRequestBody(
            "text/x-markdown; charset=utf-8".toMediaType()
    )

    val myRequestBody = MyRequestBody()

}

fun createRequestBody2() {
    val formBody: RequestBody = FormBody.Builder()
            .add("id", "001")
            .add("userName", "Hitler")
            .add("site", "Germany")
            .build()
}

fun createRequestBody3() {
    val file = File("/fileName")

    val fileRequestBody: RequestBody = file.asRequestBody(
            "text/x-markdown; charset=utf-8".toMediaType()
    )
    val multipartBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("userName", "Hitler")
            .addFormDataPart("file", "head", fileRequestBody)
            .build()


}

class MyRequestBody : RequestBody() {
    override fun contentType(): MediaType? {
        return "text/x-markdown; charset=utf-8".toMediaType()
    }

    override fun writeTo(sink: BufferedSink) {
        sink.write("Fuck you!!".toByteArray())
    }
}