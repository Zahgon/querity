package io.github.queritylib.querity.common.valueextractor;

import java.util.UUID;

public class UUIDValueExtractor implements PropertyValueExtractor<UUID> {

    @Override
    public boolean canHandle(Class<?> propertyType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UUID extractValue(Class<?> propertyType, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static boolean isUUIDType(Class<?> propertyType) {
        return UUID.class.isAssignableFrom(propertyType);
    }
}
