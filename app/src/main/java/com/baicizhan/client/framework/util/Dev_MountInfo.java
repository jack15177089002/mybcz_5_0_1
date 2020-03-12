package com.baicizhan.client.framework.util;

import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dev_MountInfo implements IDev {
    private static Dev_MountInfo dev;
    private final int DEV_EXTERNAL = 1;
    private final int DEV_INTERNAL = 0;
    public final String HEAD = "dev_mount";
    public final String LABEL = "<label>";
    public final String MOUNT_POINT = "<mount_point>";
    private final int NLABEL = 1;
    private final int NMOUNT_POINT = 3;
    private final int NPATH = 2;
    private final int NSYSFS_PATH = 4;
    public final String PATH = "<part>";
    public final String SYSFS_PATH = "<sysfs_path1...>";
    private final File VOLD_FSTAB = new File(Environment.getRootDirectory().getAbsoluteFile() + File.separator + "etc" + File.separator + "vold.fstab");
    private ArrayList<String> cache = new ArrayList<>();
    private DevInfo info;

    public class DevInfo {
        private String label;
        private String mount_point;
        private String path;
        private String sysfs_path;

        public DevInfo() {
        }

        public String getLabel() {
            return this.label;
        }

        /* access modifiers changed from: private */
        public void setLabel(String str) {
            this.label = str;
        }

        public String getMount_point() {
            return this.mount_point;
        }

        /* access modifiers changed from: private */
        public void setMount_point(String str) {
            this.mount_point = str;
        }

        public String getPath() {
            return this.path;
        }

        /* access modifiers changed from: private */
        public void setPath(String str) {
            this.path = str;
        }

        public String getSysfs_path() {
            return this.sysfs_path;
        }

        /* access modifiers changed from: private */
        public void setSysfs_path(String str) {
            this.sysfs_path = str;
        }
    }

    public static Dev_MountInfo getInstance() {
        if (dev == null) {
            dev = new Dev_MountInfo();
        }
        return dev;
    }

    private DevInfo getInfo(int i) {
        if (this.info == null) {
            this.info = new DevInfo();
        }
        try {
            initVoldFstabToCache();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (i >= this.cache.size()) {
            return null;
        }
        String[] split = ((String) this.cache.get(i)).split(" ");
        this.info.setLabel(split[1]);
        this.info.setMount_point(split[3]);
        this.info.setPath(split[2]);
        this.info.setSysfs_path(split[4]);
        return this.info;
    }

    private void initVoldFstabToCache() {
        this.cache.clear();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.VOLD_FSTAB));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                this.cache.trimToSize();
                return;
            } else if (readLine.startsWith("dev_mount")) {
                this.cache.add(readLine);
            }
        }
    }

    public DevInfo getInternalInfo() {
        return getInfo(0);
    }

    public DevInfo getExternalInfo() {
        return getInfo(1);
    }
}
