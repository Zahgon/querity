package io.github.queritylib.querity.common.valueextractor;

import java.time.LocalDateTime;

public class LocalDateTimeValueExtractor implements PropertyValueExtractor<LocalDateTime> {

    @Override
    public boolean canHandle(Class<?> propertyType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LocalDateTime extractValue(Class<?> propertyType, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static boolean isLocalDateTimeType(Class<?> cls) {
        return LocalDateTime.class.isAssignableFrom(cls);
    }

    private static LocalDateTime getLocalDateTimeValue(String value) {
        return LocalDateTime.parse(value);
    }
}
