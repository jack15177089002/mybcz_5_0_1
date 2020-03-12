package p012ch.qos.logback.classic.turbo;

import p012ch.qos.logback.classic.Level;

/* renamed from: ch.qos.logback.classic.turbo.MDCValueLevelPair */
public class MDCValueLevelPair {
    private Level level;
    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level2) {
        this.level = level2;
    }
}
