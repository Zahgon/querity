package io.github.queritylib.querity.common.valueextractor;

import java.time.LocalDate;

public class LocalDateValueExtractor implements PropertyValueExtractor<LocalDate> {

    @Override
    public boolean canHandle(Class<?> propertyType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LocalDate extractValue(Class<?> propertyType, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static boolean isLocalDateType(Class<?> cls) {
        return LocalDate.class.isAssignableFrom(cls);
    }

    private static LocalDate getLocalDateValue(String value) {
        return LocalDate.parse(value);
    }
}
