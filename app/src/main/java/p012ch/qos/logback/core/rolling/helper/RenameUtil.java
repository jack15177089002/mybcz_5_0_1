package p012ch.qos.logback.core.rolling.helper;

import java.io.File;
import p012ch.qos.logback.core.rolling.RollingFileAppender;
import p012ch.qos.logback.core.rolling.RolloverFailure;
import p012ch.qos.logback.core.spi.ContextAwareBase;
import p012ch.qos.logback.core.util.EnvUtil;
import p012ch.qos.logback.core.util.FileUtil;

/* renamed from: ch.qos.logback.core.rolling.helper.RenameUtil */
public class RenameUtil extends ContextAwareBase {
    static String RENAMING_ERROR_URL = "http://logback.qos.ch/codes.html#renamingError";

    public void rename(String str, String str2) {
        if (str.equals(str2)) {
            addWarn("Source and target files are the same [" + str + "]. Skipping.");
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            File file2 = new File(str2);
            createMissingTargetDirsIfNecessary(file2);
            addInfo("Renaming file [" + file + "] to [" + file2 + "]");
            if (!file.renameTo(file2)) {
                addWarn("Failed to rename file [" + file + "] as [" + file2 + "].");
                if (areOnDifferentVolumes(file, file2)) {
                    addWarn("Detected different file systems for source [" + str + "] and target [" + str2 + "]. Attempting rename by copying.");
                    renameByCopying(str, str2);
                    return;
                }
                addWarn("Please consider leaving the [file] option of " + RollingFileAppender.class.getSimpleName() + " empty.");
                addWarn("See also " + RENAMING_ERROR_URL);
                return;
            }
            return;
        }
        throw new RolloverFailure("File [" + str + "] does not exist.");
    }

    /* access modifiers changed from: 0000 */
    public boolean areOnDifferentVolumes(File file, File file2) {
        if (!EnvUtil.isJDK7OrHigher()) {
            return false;
        }
        try {
            if (!FileStoreUtil.areOnSameFileStore(file, file2.getParentFile())) {
                return true;
            }
            return false;
        } catch (RolloverFailure e) {
            addWarn("Error while checking file store equality", e);
            return false;
        }
    }

    public void renameByCopying(String str, String str2) {
        new FileUtil(getContext()).copy(str, str2);
        if (!new File(str).delete()) {
            addWarn("Could not delete " + str);
        }
    }

    /* access modifiers changed from: 0000 */
    public void createMissingTargetDirsIfNecessary(File file) {
        if (FileUtil.isParentDirectoryCreationRequired(file) && !FileUtil.createMissingParentDirectories(file)) {
            throw new RolloverFailure("Failed to create parent directories for [" + file.getAbsolutePath() + "]");
        }
    }

    public String toString() {
        return "c.q.l.co.rolling.helper.RenameUtil";
    }
}
