package com.xq.ge_library

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.xq.ge_library.demo.GeLogDemoActivity
import com.xq.ge_library.demo.GeTabBottomActivity
import com.xq.geui.tab.bottom.GeTabBottom
import com.xq.geui.tab.bottom.GeTabBottomInfo

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_gelog_go -> {
                startActivity(Intent(this,GeLogDemoActivity::class.java))
            }

            R.id.tv_tab_bottom -> {
                startActivity(Intent(this, GeTabBottomActivity::class.java))
            }

/*            R.id.tv_hi_refresh -> {
                startActivity(Intent(this, HiRefreshDemoActivity::class.java))
            }
            R.id.tv_hi_banner -> {
                startActivity(Intent(this, HiBannerDemoActivity::class.java))
            }
            R.id.tv_hi_taptop -> {
                startActivity(Intent(this, HiTabTopDemoActivity::class.java))
            }*/
        }
    }
}