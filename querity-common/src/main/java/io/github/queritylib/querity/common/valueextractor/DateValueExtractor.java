package io.github.queritylib.querity.common.valueextractor;

import java.time.Instant;
import java.util.Date;

public class DateValueExtractor implements PropertyValueExtractor<Date> {

    @Override
    public boolean canHandle(Class<?> propertyType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Date extractValue(Class<?> propertyType, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static boolean isDateType(Class<?> cls) {
        return Date.class.isAssignableFrom(cls);
    }

    private static Date getDateValue(String value) {
        return Date.from(Instant.parse(value));
    }
}
