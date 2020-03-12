package com.baicizhan.client.framework.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p012ch.qos.logback.classic.Level;
import p012ch.qos.logback.classic.LoggerContext;
import p012ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import p012ch.qos.logback.classic.filter.ThresholdFilter;
import p012ch.qos.logback.core.filter.EvaluatorFilter;
import p012ch.qos.logback.core.rolling.RollingFileAppender;
import p012ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import p012ch.qos.logback.core.spi.FilterReply;

/* renamed from: com.baicizhan.client.framework.log.L */
public class C0789L {
    private static final int MAX_EXTRA_LENGTH = 2048;
    public static final Logger log = getLogger();

    /* renamed from: tl */
    private static final ThreadLocal<StringBuffer> f2301tl = new ThreadLocal<>();

    public static void addExtra(String str) {
        try {
            StringBuffer stringBuffer = (StringBuffer) f2301tl.get();
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
                f2301tl.set(stringBuffer);
            }
            if (stringBuffer.length() < 2048) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(" ");
                }
                stringBuffer.append(str);
            }
        } catch (Exception e) {
        }
    }

    public static String getAndRemoveExtra() {
        StringBuffer stringBuffer = (StringBuffer) f2301tl.get();
        f2301tl.remove();
        if (stringBuffer != null) {
            return stringBuffer.toString();
        }
        return null;
    }

    private static PatternLayoutEncoder newEncoder(LoggerContext loggerContext) {
        PatternLayoutEncoder patternLayoutEncoder = new PatternLayoutEncoder();
        patternLayoutEncoder.setContext(loggerContext);
        patternLayoutEncoder.setPattern("[%d{yyyy-MM-dd HH:mm:ss}] [%level] [%class:%line] - %msg%n");
        patternLayoutEncoder.start();
        return patternLayoutEncoder;
    }

    private static Logger getLogger() {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.reset();
        TimeBasedRollingPolicy timeBasedRollingPolicy = new TimeBasedRollingPolicy();
        timeBasedRollingPolicy.setContext(loggerContext);
        timeBasedRollingPolicy.setFileNamePattern("logs/output.log.%d{yyyyMMdd}");
        timeBasedRollingPolicy.setMaxHistory(2);
        EvaluatorFilter evaluatorFilter = new EvaluatorFilter();
        evaluatorFilter.setContext(loggerContext);
        evaluatorFilter.setOnMatch(FilterReply.ACCEPT);
        evaluatorFilter.setOnMismatch(FilterReply.DENY);
        evaluatorFilter.start();
        RollingFileAppender rollingFileAppender = new RollingFileAppender();
        rollingFileAppender.setContext(loggerContext);
        rollingFileAppender.setName("OUTPUT_FILE");
        rollingFileAppender.setRollingPolicy(timeBasedRollingPolicy);
        rollingFileAppender.setEncoder(newEncoder(loggerContext));
        rollingFileAppender.addFilter(evaluatorFilter);
        timeBasedRollingPolicy.setParent(rollingFileAppender);
        timeBasedRollingPolicy.start();
        rollingFileAppender.start();
        TimeBasedRollingPolicy timeBasedRollingPolicy2 = new TimeBasedRollingPolicy();
        timeBasedRollingPolicy2.setContext(loggerContext);
        timeBasedRollingPolicy2.setFileNamePattern("logs/error.log.%d{yyyyMMdd}");
        timeBasedRollingPolicy2.setMaxHistory(2);
        ThresholdFilter thresholdFilter = new ThresholdFilter();
        thresholdFilter.setContext(loggerContext);
        thresholdFilter.setLevel(Level.WARN.toString());
        thresholdFilter.start();
        RollingFileAppender rollingFileAppender2 = new RollingFileAppender();
        rollingFileAppender2.setContext(loggerContext);
        rollingFileAppender2.setName("ERROR_FILE");
        rollingFileAppender2.addFilter(thresholdFilter);
        rollingFileAppender2.setAppend(true);
        rollingFileAppender2.setRollingPolicy(timeBasedRollingPolicy2);
        rollingFileAppender2.setEncoder(newEncoder(loggerContext));
        timeBasedRollingPolicy2.setParent(rollingFileAppender2);
        timeBasedRollingPolicy2.start();
        rollingFileAppender2.start();
        TimeBasedRollingPolicy timeBasedRollingPolicy3 = new TimeBasedRollingPolicy();
        timeBasedRollingPolicy3.setContext(loggerContext);
        timeBasedRollingPolicy3.setFileNamePattern("logs/crash.log.%d{yyyyMMdd}");
        timeBasedRollingPolicy3.setMaxHistory(2);
        ThresholdFilter thresholdFilter2 = new ThresholdFilter();
        thresholdFilter2.setContext(loggerContext);
        thresholdFilter2.setLevel(Level.ERROR.toString());
        thresholdFilter2.start();
        BaicizhanCrashEventEvaluator baicizhanCrashEventEvaluator = new BaicizhanCrashEventEvaluator();
        baicizhanCrashEventEvaluator.start();
        EvaluatorFilter evaluatorFilter2 = new EvaluatorFilter();
        evaluatorFilter2.setContext(loggerContext);
        evaluatorFilter2.setEvaluator(baicizhanCrashEventEvaluator);
        evaluatorFilter2.setOnMatch(FilterReply.ACCEPT);
        evaluatorFilter2.setOnMismatch(FilterReply.DENY);
        evaluatorFilter2.start();
        RollingFileAppender rollingFileAppender3 = new RollingFileAppender();
        rollingFileAppender3.setContext(loggerContext);
        rollingFileAppender3.setName("CRASH_FILE");
        rollingFileAppender3.setFile("logs/crash.log");
        rollingFileAppender3.setAppend(true);
        rollingFileAppender3.setRollingPolicy(timeBasedRollingPolicy3);
        rollingFileAppender3.setEncoder(newEncoder(loggerContext));
        rollingFileAppender3.addFilter(thresholdFilter2);
        rollingFileAppender3.addFilter(evaluatorFilter2);
        timeBasedRollingPolicy3.setParent(rollingFileAppender3);
        timeBasedRollingPolicy3.start();
        rollingFileAppender3.start();
        p012ch.qos.logback.classic.Logger logger = (p012ch.qos.logback.classic.Logger) LoggerFactory.getLogger("log.baicizhan");
        logger.setAdditive(false);
        logger.setLevel(Level.ALL);
        logger.addAppender(rollingFileAppender2);
        logger.addAppender(rollingFileAppender);
        logger.addAppender(rollingFileAppender3);
        return LoggerFactory.getLogger("log.baicizhan");
    }
}
