package com.xq.log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Desc：log管理类
 */
public class GeLogManager {
    private GeLogConfig config;
    private static GeLogManager instance;
    private List<GeLogPrinter> printers = new ArrayList<>(); //保存打印器

    private GeLogManager(GeLogConfig config,GeLogPrinter[] printers) {
        this.config = config;
        this.printers.addAll(Arrays.asList(printers));
    }

    private GeLogManager(GeLogConfig config) {
        this.config = config;
    }

    public static GeLogManager getInstance() {
        return instance;
    }

    public static void init(@NonNull GeLogConfig config,GeLogPrinter...printers) {
        instance = new GeLogManager(config,printers);
    }

    public GeLogConfig getConfig() {
        return config;
    }

    public List<GeLogPrinter> getPrinters() {
        return printers;
    }

    public void addPrinter(GeLogPrinter printer) {
        printers.add(printer);
    }

    public void removePrinter(GeLogPrinter printer) {
        if(printers != null) {
            printers.remove(printer);
        }
    }
}
