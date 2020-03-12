package p012ch.qos.logback.core.util;

/* renamed from: ch.qos.logback.core.util.CharSequenceState */
class CharSequenceState {

    /* renamed from: c */
    final char f1672c;
    int occurrences = 1;

    public CharSequenceState(char c) {
        this.f1672c = c;
    }

    /* access modifiers changed from: 0000 */
    public void incrementOccurrences() {
        this.occurrences++;
    }
}
