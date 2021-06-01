package com.xq.log;

import android.util.Log;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Desc：log类型
 * author：Christiano
 * gitee:
 * time：2021/05/31 16:05
 */
public class GeLogType {
    @IntDef({V,D,I,W,E,A})//注解的接受类型
    @Retention(RetentionPolicy.SOURCE)
    public @interface TYPE {

    }
    public final static int V = Log.VERBOSE;
    public final static int D = Log.DEBUG;
    public final static int I = Log.INFO;
    public final static int W = Log.WARN;
    public final static int E = Log.ERROR;
    public final static int A = Log.ASSERT;
}
