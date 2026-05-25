package io.github.queritylib.querity.common.valueextractor;

import java.time.ZonedDateTime;

public class ZonedDateTimeValueExtractor implements PropertyValueExtractor<ZonedDateTime> {

    @Override
    public boolean canHandle(Class<?> propertyType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ZonedDateTime extractValue(Class<?> propertyType, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static boolean isZonedDateTimeType(Class<?> cls) {
        return ZonedDateTime.class.isAssignableFrom(cls);
    }

    private static ZonedDateTime getZonedDateTimeValue(String value) {
        return ZonedDateTime.parse(value);
    }
}
