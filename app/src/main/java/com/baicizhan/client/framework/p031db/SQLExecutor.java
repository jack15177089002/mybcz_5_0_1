package com.baicizhan.client.framework.p031db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.log.LSwitcher;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* renamed from: com.baicizhan.client.framework.db.SQLExecutor */
public class SQLExecutor {
    private static final Map<Class<?>, String> BASIC_TYPE_MAPPING;
    private static final int MAX_RECURSIVE_LEVEL = 10;
    protected String[] args = null;

    /* renamed from: db */
    protected SQLiteDatabase f2300db = null;
    protected Cursor resultSet = null;
    protected String sql = null;

    static {
        HashMap hashMap = new HashMap();
        BASIC_TYPE_MAPPING = hashMap;
        hashMap.put(Integer.TYPE, "Int");
        BASIC_TYPE_MAPPING.put(Double.TYPE, Double.class.getSimpleName());
        BASIC_TYPE_MAPPING.put(Character.TYPE, "String");
        BASIC_TYPE_MAPPING.put(Long.TYPE, Long.class.getSimpleName());
        BASIC_TYPE_MAPPING.put(Float.TYPE, Float.class.getSimpleName());
        BASIC_TYPE_MAPPING.put(Short.TYPE, Short.class.getSimpleName());
        BASIC_TYPE_MAPPING.put(Integer.class, "Int");
        BASIC_TYPE_MAPPING.put(Double.class, Double.class.getSimpleName());
        BASIC_TYPE_MAPPING.put(Character.class, "String");
        BASIC_TYPE_MAPPING.put(Long.class, Long.class.getSimpleName());
        BASIC_TYPE_MAPPING.put(Float.class, Float.class.getSimpleName());
        BASIC_TYPE_MAPPING.put(Short.class, Short.class.getSimpleName());
        BASIC_TYPE_MAPPING.put(String.class, String.class.getSimpleName());
        BASIC_TYPE_MAPPING.put(byte[].class, "Blob");
    }

    public SQLExecutor(SQLiteDatabase sQLiteDatabase, String str, Object... objArr) {
        this.f2300db = sQLiteDatabase;
        this.sql = str;
        if (objArr != null && objArr.length > 0) {
            this.args = new String[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                this.args[i] = objArr[i] == null ? null : objArr[i].toString();
            }
        }
    }

    public void close() {
        closeResultSet();
    }

    /* access modifiers changed from: protected */
    public void closeResultSet() {
        if (this.resultSet != null && !this.resultSet.isClosed()) {
            try {
                this.resultSet.close();
            } catch (Exception e) {
            }
            this.resultSet = null;
        }
    }

    public boolean execute() {
        if (this.args == null || this.args.length == 0) {
            this.f2300db.execSQL(this.sql);
        } else {
            this.f2300db.execSQL(this.sql, this.args);
        }
        return true;
    }

    public Cursor executeQuery() {
        closeResultSet();
        this.resultSet = this.f2300db.rawQuery(this.sql, this.args);
        return this.resultSet;
    }

    public <T> T executeQueryAsSingleResult(Class<T> cls) {
        List executeQuery = executeQuery(cls, 1);
        if (executeQuery == null || executeQuery.size() <= 0) {
            return null;
        }
        return (T) executeQuery.get(0);
    }

    public int executeUpdate() {
        int i = 0;
        if (this.args == null || this.args.length == 0) {
            this.f2300db.execSQL(this.sql);
        } else {
            this.f2300db.execSQL(this.sql, this.args);
        }
        Cursor rawQuery = this.f2300db.rawQuery("SELECT changes() AS affected_row_count", null);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToNext()) {
                    i = rawQuery.getInt(rawQuery.getColumnIndex("affected_row_count"));
                }
            } catch (Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return i;
    }

    public int executeInsertAndGetId() {
        if (this.args == null || this.args.length == 0) {
            this.f2300db.execSQL(this.sql);
        } else {
            this.f2300db.execSQL(this.sql, this.args);
        }
        return getLastInsertId();
    }

    public <T> List<T> executeQuery(Class<T> cls) {
        return executeQuery(cls, 0);
    }

    /* JADX INFO: finally extract failed */
    public <T> List<T> executeQuery(Class<T> cls, int i) {
        Object obj;
        closeResultSet();
        Cursor rawQuery = this.f2300db.rawQuery(this.sql, this.args);
        ArrayList arrayList = new ArrayList();
        try {
            HashSet hashSet = new HashSet();
            int columnCount = rawQuery.getColumnCount();
            for (int i2 = 0; i2 < columnCount; i2++) {
                String[] split = rawQuery.getColumnName(i2).split("\\.");
                String str = "";
                for (int i3 = 0; i3 < split.length; i3++) {
                    if (i3 > 0) {
                        str = str + ".";
                    }
                    str = str + split[i3];
                    hashSet.add(str);
                }
            }
            if (i <= 0) {
                i = Integer.MAX_VALUE;
            }
            while (rawQuery.moveToNext()) {
                int i4 = i - 1;
                if (i <= 0) {
                    break;
                }
                if (cls.isPrimitive() || BASIC_TYPE_MAPPING.containsKey(cls)) {
                    obj = processBasicType(rawQuery, cls);
                } else {
                    obj = processNormalObject(rawQuery, cls, null, 0, hashSet);
                }
                arrayList.add(obj);
                i = i4;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    public void setArgs(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < strArr.length; i++) {
                stringBuffer.append(" " + strArr[i]);
            }
            this.args = strArr;
            if (LSwitcher.isOpened()) {
                C0789L.log.debug("sql args [{}]", (Object) stringBuffer.toString());
            }
        }
    }

    private <T> T processBasicType(Cursor cursor, Class<T> cls) {
        return doProcessBasicType(cursor, cls, 0);
    }

    private <T> T doProcessBasicType(Cursor cursor, Class<T> cls, int i) {
        String str = (String) BASIC_TYPE_MAPPING.get(cls);
        if (str == null) {
            return null;
        }
        try {
            return (T) cursor.getClass().getMethod("get" + str, new Class[]{Integer.TYPE}).invoke(cursor, new Object[]{Integer.valueOf(i)});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    private <T> T processBasicType(Cursor cursor, Class<T> cls, String str) {
        return doProcessBasicType(cursor, cls, cursor.getColumnIndex(str));
    }

    private <T> T processNormalObject(Cursor cursor, Class<T> cls, String str, int i, Set<String> set) {
        boolean z;
        Object obj;
        if (i >= 10) {
            return null;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields == null || declaredFields.length == 0) {
            return null;
        }
        AccessibleObject.setAccessible(declaredFields, true);
        Object newInstance = null;
        try {
            newInstance = cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        boolean z2 = false;
        if (str == null) {
            str = "";
        }
        int length = declaredFields.length;
        int i2 = 0;
        while (i2 < length) {
            Field field = declaredFields[i2];
            String name = field.getName();
            Class type = field.getType();
            try {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i3 = 0; i3 < name.length(); i3++) {
                    char charAt = name.charAt(i3);
                    if (charAt < 'A' || charAt > 'Z') {
                        stringBuffer.append(charAt);
                    } else {
                        stringBuffer.append("_" + Character.toLowerCase(charAt));
                    }
                }
                try {
                    String str2 = str + stringBuffer.toString();
                    if (cls.isPrimitive() || BASIC_TYPE_MAPPING.containsKey(type)) {
                        obj = processBasicType(cursor, type, str2);
                    } else if (set.contains(str2)) {
                        obj = processNormalObject(cursor, type, str2 + ".", i + 1, set);
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        z = z2;
                    } else {
                        try {
                            field.set(newInstance, obj);
                            z = true;
                        } catch (Exception e) {
                            String str3 = "set" + name.substring(0, 1).toUpperCase(Locale.CHINA);
                            if (name.length() > 1) {
                                str3 = str3 + name.substring(1);
                            }
                            try {
                                cls.getMethod(str3, new Class[]{type}).invoke(newInstance, new Object[]{obj});
                                z = true;
                            } catch (Exception e2) {
                                z = z2;
                            }
                        }
                    }
                } catch (Exception e3) {
                    z = z2;
                }
            } catch (Exception e4) {
                z = z2;
            }
            i2++;
            z2 = z;
        }
        if (z2) {
            return (T) newInstance;
        }
        return null;
    }

    public int getLastInsertId() {
        closeResultSet();
        int i = -1;
        Cursor rawQuery = this.f2300db.rawQuery("SELECT LAST_INSERT_ROWID()", null);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToNext()) {
                    i = rawQuery.getInt(0);
                }
            } catch (Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return i;
    }
}
