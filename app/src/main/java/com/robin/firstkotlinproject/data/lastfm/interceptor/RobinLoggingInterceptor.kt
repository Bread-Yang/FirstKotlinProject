package com.robin.firstkotlinproject.data.lastfm.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit

/**
 * Created by Robin Yang on 11/23/17.
 */
class RobinLoggingInterceptor : Interceptor {

    companion object {
        val TAG: String = "RobinLoggingInterceptor"
    }

    override fun intercept(chain: Interceptor.Chain): Response {

        val utf8: Charset = Charset.forName("UTF-8")

        val request = chain.request()
        val requestBody = request.body()

        var requestString: String? = null

        requestBody?.let {
            val buffer = Buffer()
            requestBody.writeTo(buffer)

            var charset: Charset? = utf8
            val contentType = requestBody.contentType()
            contentType?.let {
                charset = contentType.charset(utf8)
            }
            requestString = buffer.readString(charset)
        }

        Log.e(TAG, "发送请求\nmethod：${request.method()}\nurl：${request.url()}\nheaders: ${request.headers()}body：$requestString")

        val startNanoTime: Long = System.nanoTime()
        val response = chain.proceed(request)
        val tookMillseconds = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startNanoTime)

        val responseBody: ResponseBody? = response.body()
        var responseString: String? = null

        val source = responseBody?.source()
        source?.request(Long.MAX_VALUE)  // Buffer the entire body
        val buffer = source?.buffer()

        var charset: Charset? = utf8
        val contentType = responseBody?.contentType()
        contentType?.let {
            charset = contentType.charset(utf8)
        }
        responseString = buffer?.clone()?.readString(charset)

        Log.e(TAG, "收到响应 ${response.code()}${response.message()} ${tookMillseconds}s\n请求url：${response.request().url()}\n请求body：$requestBody\n响应body：$responseString")

        return response
    }
}