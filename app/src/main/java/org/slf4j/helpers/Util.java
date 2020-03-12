package org.slf4j.helpers;

public class Util {
    public static final void report(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    public static final void report(String str) {
        System.err.println("SLF4J: " + str);
    }
}
