package com.xq.geui.tab.common;

import androidx.annotation.NonNull;
import androidx.annotation.Px;

/**
 * HiTab对外接口
 */
public interface IGeTab<D> extends IGeTabLayout.OnTabSelectedListener<D> {

    void setGeTabInfo(@NonNull D data);

    /**
     * 动态修改某个item的大小
     * @param height
     */
    void resetHeight(@Px int height);

}

