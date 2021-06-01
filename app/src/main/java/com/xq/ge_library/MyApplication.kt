package com.xq.ge_library

import android.app.Application
import com.google.gson.Gson
import com.xq.log.GeConsolePrinter
import com.xq.log.GeLogConfig
import com.xq.log.GeLogManager

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/05/31 17:27
 */
class MyApplication :Application() {
    override fun onCreate() {
        super.onCreate()

        GeLogManager.init(object :GeLogConfig() {

            override fun injectJsonParser(): JsonParser {
                return JsonParser { src -> Gson().toJson(src) }
            }

            override fun getGlobalTag(): String {
                return "MyApplication"
            }

            override fun enable(): Boolean {
                return true
            }
        }, GeConsolePrinter())
    }
}