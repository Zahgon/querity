package io.github.queritylib.querity.spring.data.mongodb;

import io.github.queritylib.querity.api.PropertyExpression;
import io.github.queritylib.querity.api.SimpleSort;
import lombok.experimental.Delegate;

class MongodbSimpleSort extends MongodbSort {

    @Delegate
    private final SimpleSort simpleSort;

    public MongodbSimpleSort(SimpleSort simpleSort) {
        this.simpleSort = simpleSort;
    }

    @Override
    public org.springframework.data.domain.Sort.Order toMongoSortOrder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static String mapFieldName(String fieldName) {
        return "id".equals(fieldName) ? "_id" : fieldName;
    }
}
