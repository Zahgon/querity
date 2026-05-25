package io.github.queritylib.querity.common.valueextractor;

public class EnumValueExtractor implements PropertyValueExtractor<Object> {

    @Override
    public boolean canHandle(Class<?> propertyType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Object extractValue(Class<?> propertyType, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean isValueOfType(Object value, Class<?> propertyType) {
        return propertyType.isAssignableFrom(value.getClass());
    }
}
