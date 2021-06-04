package com.xq.geui.tab.common;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/06/02 16:12
 */
public interface IGeTabLayout<Tab extends ViewGroup, D> {
    Tab findTab(@NonNull D data); //泛型tab，可以代表顶部导航tab 也可以代表底部tab。作用查找tab；D代表数据

    void addTabSelectedChangeListener(OnTabSelectedListener<D> listener); //监听器

    void defaultSelected(@NonNull D defaultInfo); //设置默认选中

    void inflateInfo(@NonNull List<D> infoList); //对数据初始化

    interface OnTabSelectedListener<D> {
        void onTabSelectedChange(int index, @Nullable D prevInfo, @NonNull D nextInfo);
    }
}