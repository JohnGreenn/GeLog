package com.xq.log;

import android.util.Log;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import static com.xq.log.GeLogConfig.MAX_LEN;

/**
 * Desc：控制台打印器
 */
public class GeConsolePrinter implements GeLogPrinter{

    @Override
    public void print(@NotNull GeLogConfig config,int level,String tag,@NotNull String printString) {
        int len = printString.length();
        int countOfSub = len / MAX_LEN;
        if (countOfSub > 0) {
            StringBuilder log = new StringBuilder();
            int index = 0;
            for (int i = 0; i < countOfSub; i++) {
                log.append(printString.substring(index, index + MAX_LEN));
                //Log.println(level,tag,printString.substring(index,index+MAX_LEN));
                index += MAX_LEN;
            }
            if (index != len) {
                log.append(printString.substring(index, len));
            }
            Log.println(level, tag, log.toString());
        } else {
            Log.println(level, tag, printString);
        }
    }
}
