package com.xq.ge_library.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.xq.ge_library.R
import com.xq.log.GeLog
import com.xq.log.GeLogConfig
import com.xq.log.GeLogType

class GeLogDemoActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ge_log_demo)
        findViewById<View>(R.id.btn_gelog).setOnClickListener{
            printLog()
        }
    }

    private fun printLog() {
        //自定义log配置
        GeLog.log(object : GeLogConfig() {
            override fun includeThread(): Boolean {
                return true
            }

            override fun stackTraceDepth(): Int {
                return 0
            }
        },GeLogType.E,"------","5566")
        GeLog.a("9900")
    }
}