package com.baicizhan.client.business.dataset.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cursors {
    private static final Map<Class<?>, String> BASIC_TYPE_MAPPING;
    private static final String TAG = "baicizhandb";

    public interface CursorMapper<T> {
        T apply(Cursor cursor);
    }

    public interface CursorReducer<T> {
        T apply(T t, Cursor cursor);
    }

    public interface KeyGetter<K, T> {
        K get(T t);
    }

    static {
        HashMap hashMap = new HashMap();
        BASIC_TYPE_MAPPING = hashMap;
        hashMap.put(Integer.TYPE, "getInt");
        BASIC_TYPE_MAPPING.put(Integer.class, "getInt");
        BASIC_TYPE_MAPPING.put(Double.TYPE, "getDouble");
        BASIC_TYPE_MAPPING.put(Double.class, "getDouble");
        BASIC_TYPE_MAPPING.put(Character.TYPE, "getString");
        BASIC_TYPE_MAPPING.put(Character.class, "getString");
        BASIC_TYPE_MAPPING.put(Long.TYPE, "getLong");
        BASIC_TYPE_MAPPING.put(Long.class, "getLong");
        BASIC_TYPE_MAPPING.put(Float.TYPE, "getFloat");
        BASIC_TYPE_MAPPING.put(Float.class, "getFloat");
        BASIC_TYPE_MAPPING.put(Short.TYPE, "getShort");
        BASIC_TYPE_MAPPING.put(Short.class, "getShort");
        BASIC_TYPE_MAPPING.put(byte[].class, "getBlob");
        BASIC_TYPE_MAPPING.put(Byte[].class, "getBlob");
        BASIC_TYPE_MAPPING.put(String.class, "getString");
    }

    public static boolean isCursorEmpty(Cursor cursor) {
        return cursor == null || cursor.getCount() == 0;
    }

    public static int getCursorRows(Cursor cursor) {
        if (cursor == null) {
            return 0;
        }
        return cursor.getCount();
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.util.List<T>] */
    /* JADX WARNING: type inference failed for: r0v6, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r0v7, types: [java.util.List] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v3, types: [java.util.List]
  assigns: [java.util.List, java.util.ArrayList]
  uses: [java.util.List<T>, java.util.ArrayList]
  mth insns count: 27
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> List<T> mapToList(Cursor r2, CursorMapper<T> r3) {
        /*
            boolean r0 = isCursorEmpty(r2)     // Catch:{ Exception -> 0x002d }
            if (r0 == 0) goto L_0x0010
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ Exception -> 0x002d }
            if (r2 == 0) goto L_0x000f
            r2.close()
        L_0x000f:
            return r0
        L_0x0010:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x002d }
            int r1 = r2.getCount()     // Catch:{ Exception -> 0x002d }
            r0.<init>(r1)     // Catch:{ Exception -> 0x002d }
            r2.moveToFirst()     // Catch:{ Exception -> 0x002d }
        L_0x001c:
            boolean r1 = r2.isAfterLast()     // Catch:{ Exception -> 0x002d }
            if (r1 != 0) goto L_0x0041
            java.lang.Object r1 = r3.apply(r2)     // Catch:{ Exception -> 0x002d }
            r0.add(r1)     // Catch:{ Exception -> 0x002d }
            r2.moveToNext()     // Catch:{ Exception -> 0x002d }
            goto L_0x001c
        L_0x002d:
            r0 = move-exception
            java.lang.String r1 = "baicizhandb"
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)     // Catch:{ all -> 0x0047 }
            android.util.Log.e(r1, r0)     // Catch:{ all -> 0x0047 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x000f
            r2.close()
            goto L_0x000f
        L_0x0041:
            if (r2 == 0) goto L_0x000f
            r2.close()
            goto L_0x000f
        L_0x0047:
            r0 = move-exception
            if (r2 == 0) goto L_0x004d
            r2.close()
        L_0x004d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.dataset.provider.Cursors.mapToList(android.database.Cursor, com.baicizhan.client.business.dataset.provider.Cursors$CursorMapper):java.util.List");
    }

    public static <T> List<T> mapToList(Cursor cursor, Class<T> cls) {
        return mapToList(cursor, cls, null);
    }

    public static <T> List<T> mapToList(Cursor cursor, final Class<T> cls, final Map<String, String> map) {
        return mapToList(cursor, (CursorMapper<T>) new CursorMapper<T>() {
            public final T apply(Cursor cursor) {
                return Cursors.convertObject(cursor, cls, map);
            }
        });
    }

    public static <T> T mapToUnique(Cursor cursor, CursorMapper<T> cursorMapper) {
        T t = null;
        try {
            if (!isCursorEmpty(cursor)) {
                cursor.moveToFirst();
                t = cursorMapper.apply(cursor);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            Log.e("baicizhandb", Log.getStackTraceString(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return t;
    }

    public static <T> T mapToUnique(Cursor cursor, Class<T> cls) {
        return mapToUnique(cursor, cls, null);
    }

    public static <T> T mapToUnique(Cursor cursor, final Class<T> cls, final Map<String, String> map) {
        return mapToUnique(cursor, (CursorMapper<T>) new CursorMapper<T>() {
            public final T apply(Cursor cursor) {
                try {
                    return Cursors.convertObject(cursor, cls, map);
                } catch (Exception e) {
                    Log.e("baicizhandb", Log.getStackTraceString(e));
                    return null;
                }
            }
        });
    }

    public static <T> T reduce(Cursor cursor, CursorReducer<T> cursorReducer, T t) {
        try {
            if (!isCursorEmpty(cursor)) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    t = cursorReducer.apply(t, cursor);
                    cursor.moveToNext();
                }
                if (cursor == null) {
                    return t;
                }
                cursor.close();
                return t;
            } else if (cursor == null) {
                return t;
            } else {
                cursor.close();
                return t;
            }
        } catch (Exception e) {
            Log.e("baicizhandb", Log.getStackTraceString(e));
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static <K, T> Map<K, T> reduceToDict(Cursor cursor, final Class<T> cls, final Map<String, String> map, final KeyGetter<K, T> keyGetter) {
        return (Map) reduce(cursor, new CursorReducer<Map<K, T>>() {
            public final Map<K, T> apply(Map<K, T> map, Cursor cursor) {
                T access$000 = Cursors.convertObject(cursor, cls, (Map<String, String>) map);
                map.put(keyGetter.get(access$000), access$000);
                return map;
            }
        }, new ArrayMap());
    }

    public static <T> SparseArray<T> reduceToSparseArray(Cursor cursor, final Class<T> cls, final Map<String, String> map, final KeyGetter<Integer, T> keyGetter) {
        return (SparseArray) reduce(cursor, new CursorReducer<SparseArray<T>>() {
            public final SparseArray<T> apply(SparseArray<T> sparseArray, Cursor cursor) {
                T access$000 = Cursors.convertObject(cursor, cls, map);
                sparseArray.put(((Integer) keyGetter.get(access$000)).intValue(), access$000);
                return sparseArray;
            }
        }, new SparseArray());
    }

    public static <T> Set<T> reduceToSet(Cursor cursor, final Class<T> cls, final Map<String, String> map) {
        return (Set) reduce(cursor, new CursorReducer<Set<T>>() {
            public final Set<T> apply(Set<T> set, Cursor cursor) {
                set.add(Cursors.convertObject(cursor, cls, map));
                return set;
            }
        }, new HashSet());
    }

    public static int toSimpleInt(Cursor cursor) {
        int i = 0;
        try {
            if (!isCursorEmpty(cursor)) {
                cursor.moveToFirst();
                i = cursor.getInt(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return i;
    }

    public static long toSimpleLong(Cursor cursor) {
        long j = 0;
        try {
            if (!isCursorEmpty(cursor)) {
                cursor.moveToFirst();
                j = (long) cursor.getInt(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return j;
    }

    public static String toSimpleString(Cursor cursor) {
        String str = null;
        try {
            if (!isCursorEmpty(cursor)) {
                cursor.moveToFirst();
                str = cursor.getString(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return str;
    }

    public static byte[] toSimpleBlob(Cursor cursor) {
        byte[] bArr = null;
        try {
            if (!isCursorEmpty(cursor)) {
                cursor.moveToFirst();
                bArr = cursor.getBlob(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            Log.e("baicizhandb", Log.getStackTraceString(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return bArr;
    }

    public static float toSimpleFloat(Cursor cursor) {
        float f = 0.0f;
        try {
            if (!isCursorEmpty(cursor)) {
                cursor.moveToFirst();
                f = cursor.getFloat(0);
                cursor.close();
            }
        } catch (Exception e) {
        } finally {
            cursor.close();
        }
        return f;
    }

    public static double toSimpleDouble(Cursor cursor) {
        double d = 0.0d;
        try {
            if (!isCursorEmpty(cursor)) {
                cursor.moveToFirst();
                d = cursor.getDouble(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return d;
    }

    private static <T> T convertBasicType(Cursor cursor, Class<T> cls, int i) {
        String str = (String) BASIC_TYPE_MAPPING.get(cls);
        if (str == null) {
            return null;
        }
        try {
            return (T) cursor.getClass().getMethod(str, new Class[]{Integer.TYPE}).invoke(cursor, new Object[]{Integer.valueOf(i)});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static <T> T convertBasicType(Cursor cursor, Class<T> cls, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex == -1) {
            return null;
        }
        return convertBasicType(cursor, cls, columnIndex);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        if (r0 != null) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void inflateFromCursor(T r11, Cursor r12, Class<T> r13, Map<String, String> r14) {
        /*
            r3 = 0
            r10 = 1
            java.lang.reflect.Field[] r4 = r13.getDeclaredFields()
            java.lang.reflect.AccessibleObject.setAccessible(r4, r10)
            int r5 = r4.length
            r2 = r3
        L_0x000b:
            if (r2 >= r5) goto L_0x00b0
            r6 = r4[r2]
            int r0 = r6.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isStatic(r0)
            if (r1 != 0) goto L_0x0042
            boolean r0 = java.lang.reflect.Modifier.isTransient(r0)
            if (r0 != 0) goto L_0x0042
            java.lang.Class r7 = r6.getType()
            java.lang.String r1 = r6.getName()
            if (r14 == 0) goto L_0x00b1
            java.lang.Object r0 = r14.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x00b1
        L_0x0031:
            java.util.Map<java.lang.Class<?>, java.lang.String> r8 = BASIC_TYPE_MAPPING
            boolean r8 = r8.containsKey(r7)
            if (r8 == 0) goto L_0x0046
            java.lang.Object r8 = convertBasicType(r12, r7, r0)
            if (r8 == 0) goto L_0x0042
            r6.set(r11, r8)     // Catch:{ Exception -> 0x0065 }
        L_0x0042:
            int r0 = r2 + 1
            r2 = r0
            goto L_0x000b
        L_0x0046:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "field type "
            r1.<init>(r2)
            java.lang.String r2 = r7.getName()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " not supported"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0065:
            r0 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r6 = "set"
            r0.<init>(r6)
            java.lang.String r6 = r1.substring(r3, r10)
            java.util.Locale r9 = java.util.Locale.CHINA
            java.lang.String r6 = r6.toUpperCase(r9)
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.String r0 = r0.toString()
            int r6 = r1.length()
            if (r6 <= r10) goto L_0x009a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r0 = r6.append(r0)
            java.lang.String r1 = r1.substring(r10)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x009a:
            r1 = 1
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x00ae }
            r6 = 0
            r1[r6] = r7     // Catch:{ Exception -> 0x00ae }
            java.lang.reflect.Method r0 = r13.getMethod(r0, r1)     // Catch:{ Exception -> 0x00ae }
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00ae }
            r6 = 0
            r1[r6] = r8     // Catch:{ Exception -> 0x00ae }
            r0.invoke(r11, r1)     // Catch:{ Exception -> 0x00ae }
            goto L_0x0042
        L_0x00ae:
            r0 = move-exception
            throw r0
        L_0x00b0:
            return
        L_0x00b1:
            r0 = r1
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.dataset.provider.Cursors.inflateFromCursor(java.lang.Object, android.database.Cursor, java.lang.Class, java.util.Map):void");
    }

    /* access modifiers changed from: private */
    public static <T> T convertObject(Cursor cursor, Class<T> cls, Map<String, String> map) {
        if (isCursorEmpty(cursor)) {
            return null;
        }
        if (BASIC_TYPE_MAPPING.containsKey(cls)) {
            return convertBasicType(cursor, cls, 0);
        }
        T newInstance = null;
        try {
            newInstance = cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        inflateFromCursor(newInstance, cursor, cls, map);
        return newInstance;
    }

    public static <T> ContentValues[] bulkConvertContentValues(Collection<T> collection, Class<T> cls, Map<String, String> map, String[] strArr) {
        ContentValues[] contentValuesArr = new ContentValues[collection.size()];
        int i = 0;
        for (T convertContentValues : collection) {
            contentValuesArr[i] = convertContentValues(convertContentValues, cls, map, strArr);
            i++;
        }
        return contentValuesArr;
    }

    public static <T> ContentValues[] bulkConvertContentValues(Iterator<T> it, Class<T> cls, Map<String, String> map, String[] strArr) {
        LinkedList linkedList = new LinkedList();
        while (it.hasNext()) {
            linkedList.add(convertContentValues(it.next(), cls, map, strArr));
        }
        ContentValues[] contentValuesArr = new ContentValues[linkedList.size()];
        linkedList.toArray(contentValuesArr);
        return contentValuesArr;
    }

    public static <T> ContentValues convertContentValues(T t, Class<T> cls, Map<String, String> map, String[] strArr) {
        Field[] fieldArr;
        String str;
        ContentValues contentValues = new ContentValues();
        if (strArr == null || strArr.length == 0) {
            fieldArr = cls.getDeclaredFields();
        } else {
            Field[] fieldArr2 = new Field[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                try {
                    fieldArr2[i] = cls.getDeclaredField(strArr[i]);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            fieldArr = fieldArr2;
        }
        if (fieldArr == null || fieldArr.length == 0) {
            return null;
        }
        AccessibleObject.setAccessible(fieldArr, true);
        for (Field field : fieldArr) {
            int modifiers = field.getModifiers();
            if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers)) {
                Class<Float> type = (Class<Float>) field.getType();
                String name = field.getName();
                if (map != null) {
                    String str2 = (String) map.get(name);
                    if (str2 != null) {
                        str = str2;
                    } else {
                        continue;
                    }
                } else {
                    str = name;
                }
//                if (type == Integer.class || type == Integer.TYPE) {
//                    contentValues.put(str, Integer.valueOf(field.getInt(t)));
//                } else if (type == Long.class || type == Long.TYPE) {
//                    contentValues.put(str, Long.valueOf(field.getLong(t)));
//                } else if (type == String.class) {
//                    contentValues.put(str, (String) field.get(t));
//                } else if (type == byte[].class) {
//                    contentValues.put(str, (byte[]) field.get(t));
//                } else if (type == Short.class || type == Short.TYPE) {
//                    contentValues.put(str, Short.valueOf(field.getShort(t)));
//                } else if (type == Boolean.class || type == Boolean.TYPE) {
//                    contentValues.put(str, Boolean.valueOf(field.getBoolean(t)));
//                } else if (type == Double.class || type == Double.TYPE) {
//                    contentValues.put(str, Double.valueOf(field.getDouble(t)));
//                } else if (type == Float.class || type == Float.TYPE) {
//                    contentValues.put(str, Float.valueOf(field.getFloat(t)));
//                } else {
//                    throw new Exception("field[" + name + "] with type " + type.getSimpleName() + " not supported.");
//                }
            }
        }
        return contentValues;
    }

    public static int safeBulkInsert(Context context, Uri uri, ContentValues[] contentValuesArr, int i) {
        int i2 = 0;
        ContentResolver contentResolver = context.getContentResolver();
        if (i <= 0 || contentValuesArr.length <= i) {
            return contentResolver.bulkInsert(uri, contentValuesArr);
        }
        ContentValues[] contentValuesArr2 = new ContentValues[i];
        int i3 = 0;
        while (i2 < contentValuesArr.length) {
            int min = Math.min(contentValuesArr.length, i2 + i);
            for (int i4 = i2; i4 < min; i4++) {
                contentValuesArr2[i4 - i2] = contentValuesArr[i4];
            }
            i3 += contentResolver.bulkInsert(uri, contentValuesArr2);
            i2 += i;
        }
        return i3;
    }
}
