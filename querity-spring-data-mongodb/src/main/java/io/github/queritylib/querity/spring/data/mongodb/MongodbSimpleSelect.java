package io.github.queritylib.querity.spring.data.mongodb;

import io.github.queritylib.querity.api.PropertyExpression;
import io.github.queritylib.querity.api.SimpleSelect;
import lombok.experimental.Delegate;
import org.springframework.data.mongodb.core.query.Field;

class MongodbSimpleSelect extends MongodbSelect {

    @Delegate
    private final SimpleSelect simpleSelect;

    public MongodbSimpleSelect(SimpleSelect simpleSelect) {
        this.simpleSelect = simpleSelect;
    }

    @Override
    public void applyProjection(Field field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static String mapFieldName(String fieldName) {
        // Map 'id' to MongoDB's '_id'
        return "id".equals(fieldName) ? "_id" : fieldName;
    }
}
