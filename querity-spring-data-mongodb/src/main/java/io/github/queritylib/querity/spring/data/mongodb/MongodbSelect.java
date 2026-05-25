package io.github.queritylib.querity.spring.data.mongodb;

import io.github.queritylib.querity.api.Select;
import io.github.queritylib.querity.api.SimpleSelect;
import org.springframework.data.mongodb.core.query.Field;

abstract class MongodbSelect {

    public abstract void applyProjection(Field field);

    public static MongodbSelect of(Select select) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
