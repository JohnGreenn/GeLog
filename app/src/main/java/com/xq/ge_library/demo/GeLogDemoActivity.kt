package com.xq.ge_library.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.xq.ge_library.R
import com.xq.log.*

class GeLogDemoActivity : AppCompatActivity(){
    var viewPrinter: GeViewPrinter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ge_log_demo)
        viewPrinter = GeViewPrinter(this)
        findViewById<View>(R.id.btn_gelog).setOnClickListener{
            printLog()
        }
        viewPrinter!!.viewProvider.showFloatingView()
    }

    private fun printLog() {
        //点击 打印log信息
        GeLogManager.getInstance().addPrinter(viewPrinter)
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