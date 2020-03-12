package p012ch.qos.logback.classic.android;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.slf4j.android.AndroidProperties;
import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.android.CommonPathUtil;
import p012ch.qos.logback.core.status.Status;
import p012ch.qos.logback.core.status.StatusManager;
import p012ch.qos.logback.core.status.WarnStatus;
import p012ch.qos.logback.core.util.Loader;

/* renamed from: ch.qos.logback.classic.android.AndroidManifestPropertiesUtil */
public class AndroidManifestPropertiesUtil {
    public static void setAndroidPropertiesFromManifest(Context context) {
        ASaxEventRecorder aSaxEventRecorder = new ASaxEventRecorder();
        aSaxEventRecorder.setFilter("-");
        aSaxEventRecorder.setAttributeWatch("manifest");
        StatusManager statusManager = context.getStatusManager();
        InputStream resourceAsStream = Loader.getClassLoaderOfObject(context).getResourceAsStream("AndroidManifest.xml");
        if (resourceAsStream == null) {
            statusManager.add((Status) new WarnStatus("Could not find AndroidManifest.xml", context));
            return;
        }
        try {
            aSaxEventRecorder.recordEvents(resourceAsStream);
            context.putProperty(CoreConstants.EXT_DIR_KEY, CommonPathUtil.getMountedExternalStorageDirectoryPath());
            Map attributeWatchValues = aSaxEventRecorder.getAttributeWatchValues();
//            for (String str : attributeWatchValues.keySet()) {
//                if (str.equals("android:versionName")) {
//                    context.putProperty(CoreConstants.VERSION_NAME_KEY, (String) attributeWatchValues.get(str));
//                } else if (str.equals("android:versionCode")) {
//                    context.putProperty(CoreConstants.VERSION_CODE_KEY, (String) attributeWatchValues.get(str));
//                } else if (str.equals("package")) {
//                    context.putProperty(CoreConstants.PACKAGE_NAME_KEY, (String) attributeWatchValues.get(str));
//                }
//            }
            String str2 = (String) attributeWatchValues.get("package");
            if (str2 == null || str2.length() <= 0) {
                statusManager.add((Status) new WarnStatus("Package name not found. Some properties cannot be set.", context));
            } else {
                context.putProperty(CoreConstants.DATA_DIR_KEY, CommonPathUtil.getFilesDirectoryPath(str2));
            }
        } finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
            }
        }
    }

    public static void setAndroidPropertiesFromCache(Context context) {
        context.putProperty(CoreConstants.EXT_DIR_KEY, CommonPathUtil.getMountedExternalStorageDirectoryPath());
        context.putProperty(CoreConstants.VERSION_NAME_KEY, AndroidProperties.getInstance().getVersionName());
        context.putProperty(CoreConstants.VERSION_CODE_KEY, AndroidProperties.getInstance().getVersionCode());
        context.putProperty(CoreConstants.PACKAGE_NAME_KEY, AndroidProperties.getInstance().getPackage());
        StatusManager statusManager = context.getStatusManager();
        String str = AndroidProperties.getInstance().getPackage();
        if (str == null || str.length() <= 0) {
            statusManager.add((Status) new WarnStatus("Package name not found. Some properties cannot be set.", context));
        } else {
            context.putProperty(CoreConstants.DATA_DIR_KEY, CommonPathUtil.getFilesDirectoryPath(str));
        }
    }

    public static void setAndroidProperties(Context context) {
        if (AndroidProperties.getInstance().getPackage() != null) {
            setAndroidPropertiesFromCache(context);
        } else {
            setAndroidPropertiesFromManifest(context);
        }
    }
}
