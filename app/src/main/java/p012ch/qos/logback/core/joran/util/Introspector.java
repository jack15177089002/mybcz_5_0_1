package p012ch.qos.logback.core.joran.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: ch.qos.logback.core.joran.util.Introspector */
public class Introspector {
    public static String decapitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String lowerCase = str.substring(0, 1).toLowerCase();
        if (str.length() > 1) {
            return new StringBuilder(String.valueOf(lowerCase)).append(str.substring(1)).toString();
        }
        return lowerCase;
    }

    public static MethodDescriptor[] getMethodDescriptors(Class<?> cls) {
        Method[] methods;
        ArrayList arrayList = new ArrayList();
        for (Method method : cls.getMethods()) {
            arrayList.add(new MethodDescriptor(method.getName(), method));
        }
        return (MethodDescriptor[]) arrayList.toArray(new MethodDescriptor[0]);
    }

    public static PropertyDescriptor[] getPropertyDescriptors(Class<?> cls) {
        Method[] methods;
        boolean z;
        boolean z2;
        HashMap hashMap = new HashMap();
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            if (!name.startsWith("get") || name.length() <= 3) {
                z = false;
            } else {
                z = true;
            }
            if (!name.startsWith("set") || name.length() <= 3) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z || z2) {
                String decapitalize = decapitalize(name.substring(3));
                PropertyDescriptor propertyDescriptor = (PropertyDescriptor) hashMap.get(decapitalize);
                if (propertyDescriptor == null) {
                    propertyDescriptor = new PropertyDescriptor(decapitalize);
                    hashMap.put(decapitalize, propertyDescriptor);
                }
                Class[] parameterTypes = method.getParameterTypes();
                if (z2) {
                    if (parameterTypes.length == 1) {
                        propertyDescriptor.setWriteMethod(method);
                        propertyDescriptor.setPropertyType(parameterTypes[0]);
                    }
                } else if (z && parameterTypes.length == 0) {
                    propertyDescriptor.setReadMethod(method);
                    if (propertyDescriptor.getPropertyType() == null) {
                        propertyDescriptor.setPropertyType(method.getReturnType());
                    }
                }
            }
        }
        return (PropertyDescriptor[]) hashMap.values().toArray(new PropertyDescriptor[0]);
    }
}
