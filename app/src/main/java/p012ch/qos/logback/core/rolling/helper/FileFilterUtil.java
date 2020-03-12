package p012ch.qos.logback.core.rolling.helper;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p012ch.qos.logback.classic.Level;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: ch.qos.logback.core.rolling.helper.FileFilterUtil */
public class FileFilterUtil {
    public static void sortFileArrayByName(File[] fileArr) {
        Arrays.sort(fileArr, new Comparator<File>() {
            public int compare(File file, File file2) {
                return file.getName().compareTo(file2.getName());
            }
        });
    }

    public static void reverseSortFileArrayByName(File[] fileArr) {
        Arrays.sort(fileArr, new Comparator<File>() {
            public int compare(File file, File file2) {
                return file2.getName().compareTo(file.getName());
            }
        });
    }

    public static String afterLastSlash(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    public static boolean isEmptyDirectory(File file) {
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("[" + file + "] must be a directory");
        }
        String[] list = file.list();
        if (list == null || list.length == 0) {
            return true;
        }
        return false;
    }

    public static File[] filesInFolderMatchingStemRegex(File file, final String str) {
        if (file == null) {
            return new File[0];
        }
        if (!file.exists() || !file.isDirectory()) {
            return new File[0];
        }
        return file.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.matches(str);
            }
        });
    }

    public static int findHighestCounter(File[] fileArr, String str) {
        int i = Level.ALL_INT;
        int length = fileArr.length;
        int i2 = 0;
        while (i2 < length) {
            int extractCounter = extractCounter(fileArr[i2], str);
            if (i >= extractCounter) {
                extractCounter = i;
            }
            i2++;
            i = extractCounter;
        }
        return i;
    }

    public static int extractCounter(File file, String str) {
        Pattern compile = Pattern.compile(str);
        String name = file.getName();
        Matcher matcher = compile.matcher(name);
        if (matcher.matches()) {
            return new Integer(matcher.group(1)).intValue();
        }
        throw new IllegalStateException("The regex [" + str + "] should match [" + name + "]");
    }

    public static String slashify(String str) {
        return str.replace(CoreConstants.ESCAPE_CHAR, '/');
    }

    public static void removeEmptyParentDirectories(File file, int i) {
        while (i < 3) {
            file = file.getParentFile();
            if (file.isDirectory() && isEmptyDirectory(file)) {
                file.delete();
                i++;
            } else {
                return;
            }
        }
    }
}
