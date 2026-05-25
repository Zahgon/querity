package io.github.queritylib.querity.spring.data.elasticsearch;

import io.github.queritylib.querity.api.NativeSortWrapper;
import io.github.queritylib.querity.api.SimpleSort;
import io.github.queritylib.querity.api.Sort;

abstract class ElasticsearchSort {

    public abstract org.springframework.data.domain.Sort.Order toElasticsearchSortOrder();

    @SuppressWarnings("unchecked")
    public static ElasticsearchSort of(Sort sort) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
