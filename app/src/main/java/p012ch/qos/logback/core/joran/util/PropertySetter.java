package p012ch.qos.logback.core.joran.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import p012ch.qos.logback.core.joran.spi.DefaultClass;
import p012ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import p012ch.qos.logback.core.spi.ContextAwareBase;
import p012ch.qos.logback.core.util.AggregationType;
import p012ch.qos.logback.core.util.PropertySetterException;

/* renamed from: ch.qos.logback.core.joran.util.PropertySetter */
public class PropertySetter extends ContextAwareBase {
    private static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$util$AggregationType;
    protected MethodDescriptor[] methodDescriptors;
    protected Object obj;
    protected Class<?> objClass;
    protected PropertyDescriptor[] propertyDescriptors;

    static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$util$AggregationType() {
        int[] iArr = $SWITCH_TABLE$ch$qos$logback$core$util$AggregationType;
        if (iArr == null) {
            iArr = new int[AggregationType.values().length];
            try {
                iArr[AggregationType.AS_BASIC_PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[AggregationType.AS_BASIC_PROPERTY_COLLECTION.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[AggregationType.AS_COMPLEX_PROPERTY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[AggregationType.AS_COMPLEX_PROPERTY_COLLECTION.ordinal()] = 5;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[AggregationType.NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            $SWITCH_TABLE$ch$qos$logback$core$util$AggregationType = iArr;
        }
        return iArr;
    }

    public PropertySetter(Object obj2) {
        this.obj = obj2;
        this.objClass = obj2.getClass();
    }

    /* access modifiers changed from: protected */
    public void introspect() {
        try {
            this.propertyDescriptors = Introspector.getPropertyDescriptors(this.objClass);
            this.methodDescriptors = Introspector.getMethodDescriptors(this.objClass);
        } catch (IntrospectionException e) {
            addError("Failed to introspect " + this.obj + ": " + e.getMessage());
            this.propertyDescriptors = new PropertyDescriptor[0];
            this.methodDescriptors = new MethodDescriptor[0];
        }
    }

    public void setProperty(String str, String str2) {
        if (str2 != null) {
            String decapitalize = Introspector.decapitalize(str);
            PropertyDescriptor propertyDescriptor = getPropertyDescriptor(decapitalize);
            if (propertyDescriptor == null) {
                addWarn("No such property [" + decapitalize + "] in " + this.objClass.getName() + ".");
                return;
            }
            try {
                setProperty(propertyDescriptor, decapitalize, str2);
            } catch (PropertySetterException e) {
                addWarn("Failed to set property [" + decapitalize + "] to value \"" + str2 + "\". ", e);
            }
        }
    }

    public void setProperty(PropertyDescriptor propertyDescriptor, String str, String str2) {
        Method writeMethod = propertyDescriptor.getWriteMethod();
        if (writeMethod == null) {
            throw new PropertySetterException("No setter for property [" + str + "].");
        }
        Class[] parameterTypes = writeMethod.getParameterTypes();
        if (parameterTypes.length != 1) {
            throw new PropertySetterException("#params for setter != 1");
        }
        try {
            Object convertArg = StringToObjectConverter.convertArg(this, str2, parameterTypes[0]);
            if (convertArg == null) {
                throw new PropertySetterException("Conversion to type [" + parameterTypes[0] + "] failed.");
            }
            try {
                writeMethod.invoke(this.obj, new Object[]{convertArg});
            } catch (Exception e) {
                throw new PropertySetterException((Throwable) e);
            }
        } catch (Throwable th) {
            throw new PropertySetterException("Conversion to type [" + parameterTypes[0] + "] failed. ", th);
        }
    }

    public AggregationType computeAggregationType(String str) {
        Method findAdderMethod = findAdderMethod(str);
        if (findAdderMethod != null) {
            switch ($SWITCH_TABLE$ch$qos$logback$core$util$AggregationType()[computeRawAggregationType(findAdderMethod).ordinal()]) {
                case 1:
                    return AggregationType.NOT_FOUND;
                case 2:
                    return AggregationType.AS_BASIC_PROPERTY_COLLECTION;
                case 3:
                    return AggregationType.AS_COMPLEX_PROPERTY_COLLECTION;
            }
        }
        Method findSetterMethod = findSetterMethod(str);
        if (findSetterMethod != null) {
            return computeRawAggregationType(findSetterMethod);
        }
        return AggregationType.NOT_FOUND;
    }

    private Method findAdderMethod(String str) {
        return getMethod("add" + capitalizeFirstLetter(str));
    }

    private Method findSetterMethod(String str) {
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(Introspector.decapitalize(str));
        if (propertyDescriptor != null) {
            return propertyDescriptor.getWriteMethod();
        }
        return null;
    }

    private Class<?> getParameterClassForMethod(Method method) {
        if (method == null) {
            return null;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length == 1) {
            return parameterTypes[0];
        }
        return null;
    }

    private AggregationType computeRawAggregationType(Method method) {
        Class parameterClassForMethod = getParameterClassForMethod(method);
        if (parameterClassForMethod == null) {
            return AggregationType.NOT_FOUND;
        }
        if (StringToObjectConverter.canBeBuiltFromSimpleString(parameterClassForMethod)) {
            return AggregationType.AS_BASIC_PROPERTY;
        }
        return AggregationType.AS_COMPLEX_PROPERTY;
    }

    private boolean isUnequivocallyInstantiable(Class<?> cls) {
        if (cls.isInterface()) {
            return false;
        }
        try {
            if (cls.newInstance() != null) {
                return true;
            }
            return false;
        } catch (IllegalAccessException | InstantiationException e) {
            return false;
        }
    }

    public Class<?> getObjClass() {
        return this.objClass;
    }

    public void addComplexProperty(String str, Object obj2) {
        Method findAdderMethod = findAdderMethod(str);
        if (findAdderMethod == null) {
            addError("Could not find method [add" + str + "] in class [" + this.objClass.getName() + "].");
        } else if (isSanityCheckSuccessful(str, findAdderMethod, findAdderMethod.getParameterTypes(), obj2)) {
            invokeMethodWithSingleParameterOnThisObject(findAdderMethod, obj2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void invokeMethodWithSingleParameterOnThisObject(Method method, Object obj2) {
        Class cls = obj2.getClass();
        try {
            method.invoke(this.obj, new Object[]{obj2});
        } catch (Exception e) {
            addError("Could not invoke method " + method.getName() + " in class " + this.obj.getClass().getName() + " with parameter of type " + cls.getName(), e);
        }
    }

    public void addBasicProperty(String str, String str2) {
        if (str2 != null) {
            String capitalizeFirstLetter = capitalizeFirstLetter(str);
            Method findAdderMethod = findAdderMethod(capitalizeFirstLetter);
            if (findAdderMethod == null) {
                addError("No adder for property [" + capitalizeFirstLetter + "].");
                return;
            }
            Class[] parameterTypes = findAdderMethod.getParameterTypes();
            isSanityCheckSuccessful(capitalizeFirstLetter, findAdderMethod, parameterTypes, str2);
            try {
                if (StringToObjectConverter.convertArg(this, str2, parameterTypes[0]) != null) {
                    invokeMethodWithSingleParameterOnThisObject(findAdderMethod, str2);
                }
            } catch (Throwable th) {
                addError("Conversion to type [" + parameterTypes[0] + "] failed. ", th);
            }
        }
    }

    public void setComplexProperty(String str, Object obj2) {
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(Introspector.decapitalize(str));
        if (propertyDescriptor == null) {
            addWarn("Could not find PropertyDescriptor for [" + str + "] in " + this.objClass.getName());
            return;
        }
        Method writeMethod = propertyDescriptor.getWriteMethod();
        if (writeMethod == null) {
            addWarn("Not setter method for property [" + str + "] in " + this.obj.getClass().getName());
        } else if (isSanityCheckSuccessful(str, writeMethod, writeMethod.getParameterTypes(), obj2)) {
            try {
                invokeMethodWithSingleParameterOnThisObject(writeMethod, obj2);
            } catch (Exception e) {
                addError("Could not set component " + this.obj + " for parent component " + this.obj, e);
            }
        }
    }

    private boolean isSanityCheckSuccessful(String str, Method method, Class<?>[] clsArr, Object obj2) {
        Class cls = obj2.getClass();
        if (clsArr.length != 1) {
            addError("Wrong number of parameters in setter method for property [" + str + "] in " + this.obj.getClass().getName());
            return false;
        } else if (clsArr[0].isAssignableFrom(obj2.getClass())) {
            return true;
        } else {
            addError("A \"" + cls.getName() + "\" object is not assignable to a \"" + clsArr[0].getName() + "\" variable.");
            addError("The class \"" + clsArr[0].getName() + "\" was loaded by ");
            addError("[" + clsArr[0].getClassLoader() + "] whereas object of type ");
            addError("\"" + cls.getName() + "\" was loaded by [" + cls.getClassLoader() + "].");
            return false;
        }
    }

    private String capitalizeFirstLetter(String str) {
        return new StringBuilder(String.valueOf(str.substring(0, 1).toUpperCase())).append(str.substring(1)).toString();
    }

    /* access modifiers changed from: protected */
    public Method getMethod(String str) {
        if (this.methodDescriptors == null) {
            introspect();
        }
        for (int i = 0; i < this.methodDescriptors.length; i++) {
            if (str.equals(this.methodDescriptors[i].getName())) {
                return this.methodDescriptors[i].getMethod();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public PropertyDescriptor getPropertyDescriptor(String str) {
        if (this.propertyDescriptors == null) {
            introspect();
        }
        for (int i = 0; i < this.propertyDescriptors.length; i++) {
            if (str.equals(this.propertyDescriptors[i].getName())) {
                return this.propertyDescriptors[i];
            }
        }
        return null;
    }

    public Object getObj() {
        return this.obj;
    }

    /* access modifiers changed from: 0000 */
    public Method getRelevantMethod(String str, AggregationType aggregationType) {
        String capitalizeFirstLetter = capitalizeFirstLetter(str);
        if (aggregationType == AggregationType.AS_COMPLEX_PROPERTY_COLLECTION) {
            return findAdderMethod(capitalizeFirstLetter);
        }
        if (aggregationType == AggregationType.AS_COMPLEX_PROPERTY) {
            return findSetterMethod(capitalizeFirstLetter);
        }
        throw new IllegalStateException(aggregationType + " not allowed here");
    }

    /* access modifiers changed from: 0000 */
    public <T extends Annotation> T getAnnotation(String str, Class<T> cls, Method method) {
        if (method != null) {
            return method.getAnnotation(cls);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public Class<?> getDefaultClassNameByAnnonation(String str, Method method) {
        DefaultClass defaultClass = (DefaultClass) getAnnotation(str, DefaultClass.class, method);
        if (defaultClass != null) {
            return defaultClass.value();
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public Class<?> getByConcreteType(String str, Method method) {
        Class parameterClassForMethod = getParameterClassForMethod(method);
        if (parameterClassForMethod != null && isUnequivocallyInstantiable(parameterClassForMethod)) {
            return parameterClassForMethod;
        }
        return null;
    }

    public Class<?> getClassNameViaImplicitRules(String str, AggregationType aggregationType, DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
        Class<?> findDefaultComponentType = defaultNestedComponentRegistry.findDefaultComponentType(this.obj.getClass(), str);
        if (findDefaultComponentType != null) {
            return findDefaultComponentType;
        }
        Method relevantMethod = getRelevantMethod(str, aggregationType);
        if (relevantMethod == null) {
            return null;
        }
        Class<?> defaultClassNameByAnnonation = getDefaultClassNameByAnnonation(str, relevantMethod);
        return defaultClassNameByAnnonation == null ? getByConcreteType(str, relevantMethod) : defaultClassNameByAnnonation;
    }
}
