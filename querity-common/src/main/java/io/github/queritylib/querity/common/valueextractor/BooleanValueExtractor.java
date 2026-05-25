package io.github.queritylib.querity.common.valueextractor;

public class BooleanValueExtractor implements PropertyValueExtractor<Boolean> {

    @Override
    public boolean canHandle(Class<?> propertyType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Boolean extractValue(Class<?> propertyType, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static boolean isBooleanType(Class<?> cls) {
        if (cls.isPrimitive()) {
            return boolean.class.equals(cls);
        } else {
            return Boolean.class.isAssignableFrom(cls);
        }
    }

    private static Boolean getBooleanValue(String value) {
        return Boolean.valueOf(value);
    }
}
