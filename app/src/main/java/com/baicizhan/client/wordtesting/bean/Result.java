package com.baicizhan.client.wordtesting.bean;

import java.util.Locale;
//import org.mozilla.javascript.NativeObject;

public class Result {
    private boolean finished;
    private int maxSize;
    private int minSize;
    private int sampelCount;
    private int size;

    public Result() {
    }

//    public Result(NativeObject cbVar) {
//        try {
//            this.finished = ((Boolean) cbVar.get("finished")).booleanValue();
//        } catch (Exception e) {
//        }
//        try {
//            NativeObject cbVar2 = (NativeObject) cbVar.get("data");
//            try {
//                this.sampelCount = getIntValue((Double) cbVar2.get("sampled_count"));
//            } catch (Exception e2) {
//            }
//            try {
//                this.minSize = getIntValue((Double) cbVar2.get("min_size"));
//            } catch (Exception e3) {
//            }
//            try {
//                this.maxSize = getIntValue((Double) cbVar2.get("max_size"));
//            } catch (Exception e4) {
//            }
//            try {
//                this.size = getIntValue((Double) cbVar2.get("size"));
//            } catch (Exception e5) {
//            }
//        } catch (Exception e6) {
//        }
//    }

    private int getIntValue(Double d) {
        return (int) d.doubleValue();
    }

    public String toString() {
        return String.format(Locale.CHINA, "f:%b sc:%d min:%d max:%d sz:%d", new Object[]{Boolean.valueOf(this.finished), Integer.valueOf(this.sampelCount), Integer.valueOf(this.minSize), Integer.valueOf(this.maxSize), Integer.valueOf(this.size)});
    }

    public boolean isFinished() {
        return this.finished;
    }

    public void setFinished(boolean z) {
        this.finished = z;
    }

    public int getSampelCount() {
        return this.sampelCount;
    }

    public void setSampelCount(int i) {
        this.sampelCount = i;
    }

    public int getMinSize() {
        return this.minSize;
    }

    public void setMinSize(int i) {
        this.minSize = i;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public void setMaxSize(int i) {
        this.maxSize = i;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int i) {
        this.size = i;
    }
}
