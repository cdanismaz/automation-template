package com.cd.automationtemplate.suites.utils;

public class Wait {
    public static void waitShort() {
        try {
            Thread.sleep(Integer.parseInt(PropertyManager.getProperty("wait.loading.short")) * 1000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitDefault() {
        try {
            Thread.sleep(Integer.parseInt(PropertyManager.getProperty("wait.loading.default")) * 1000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
