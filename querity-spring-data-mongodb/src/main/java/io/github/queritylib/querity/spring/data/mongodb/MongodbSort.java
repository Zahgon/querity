package io.github.queritylib.querity.spring.data.mongodb;

import io.github.queritylib.querity.api.NativeSortWrapper;
import io.github.queritylib.querity.api.SimpleSort;
import io.github.queritylib.querity.api.Sort;

abstract class MongodbSort {

    public abstract org.springframework.data.domain.Sort.Order toMongoSortOrder();

    @SuppressWarnings("unchecked")
    public static MongodbSort of(Sort sort) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
