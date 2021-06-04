package com.xq.ge_library.demo

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.xq.ge_library.R
import com.xq.geui.tab.bottom.GeTabBottomInfo
import com.xq.geui.tab.bottom.GeTabBottomLayout
import com.xq.log.HiDisplayUtil

class GeTabBottomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ge_tab_bottom)
        initTabBottom()
    }

    private fun initTabBottom() {
        val geTabBottomLayout: GeTabBottomLayout = findViewById(R.id.getablayout)
        geTabBottomLayout.setTabAlpha(0.85f)
        val bottomInfoList: MutableList<GeTabBottomInfo<*>> = ArrayList()
        //删除mipmap-anydpi-v26 xml @https://hymane.itscoder.com/bitmap-factory-decode-return-null/
//            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//            HiTabInfo info = new HiTabInfo("tab" + i, bitmap, bitmap);
        val homeInfo = GeTabBottomInfo(
            "首页",
            "fonts/iconfont.ttf",
            getString(R.string.if_home),
            null,
            "#ff656667",
            "#ffd44949"
        )
        val infoRecommend = GeTabBottomInfo(
            "收藏",
            "fonts/iconfont.ttf",
            getString(R.string.if_favorite),
            null,
            "#ff656667",
            "#ffd44949"
        )

//        val infoCategory = HiTabInfo(
//            "分类",
//            "fonts/iconfont.ttf",
//            getString(R.string.if_category),
//            null,
//            "#ff656667",
//            "#ffd44949"
//        )
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.fire, null)

        val infoCategory = GeTabBottomInfo<String>(
            "分类",
            bitmap,
            bitmap
        )
        val infoChat = GeTabBottomInfo(
            "推荐",
            "fonts/iconfont.ttf",
            getString(R.string.if_recommend),
            null,
            "#ff656667",
            "#ffd44949"
        )
        val infoProfile = GeTabBottomInfo(
            "我的",
            "fonts/iconfont.ttf",
            getString(R.string.if_profile),
            null,
            "#ff656667",
            "#ffd44949"
        )
        bottomInfoList.add(homeInfo)
        bottomInfoList.add(infoRecommend)
        bottomInfoList.add(infoCategory)
        bottomInfoList.add(infoChat)
        bottomInfoList.add(infoProfile)
        geTabBottomLayout.inflateInfo(bottomInfoList)
//        Handler().postDelayed(Runnable {
//            infoList.removeAt(1)
//            hiTabBottomLayout.inflateInfo(infoList)
//            hiTabBottomLayout.defaultSelected(homeInfo)
//        },2000)

        geTabBottomLayout.addTabSelectedChangeListener { _, _, nextInfo ->
            Toast.makeText(this@GeTabBottomActivity, nextInfo.name, Toast.LENGTH_SHORT).show()
        }
        geTabBottomLayout.defaultSelected(homeInfo)
        //        改变某个tab的高度
/*        val tabBottom = geTabBottomLayout.findTab(bottomInfoList[2])
        tabBottom?.apply { resetHeight(HiDisplayUtil.dp2px(66f, resources)) }*/
    }
}
