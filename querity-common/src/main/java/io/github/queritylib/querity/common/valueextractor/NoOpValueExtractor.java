package io.github.queritylib.querity.common.valueextractor;

public class NoOpValueExtractor implements PropertyValueExtractor<Object> {

    @Override
    public boolean canHandle(Class<?> propertyType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object extractValue(Class<?> propertyType, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
