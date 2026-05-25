package io.github.queritylib.querity.spring.data.elasticsearch;

import io.github.queritylib.querity.api.PropertyExpression;
import io.github.queritylib.querity.api.SimpleSort;
import lombok.experimental.Delegate;

class ElasticsearchSimpleSort extends ElasticsearchSort {

    @Delegate
    private final SimpleSort simpleSort;

    public ElasticsearchSimpleSort(SimpleSort simpleSort) {
        this.simpleSort = simpleSort;
    }

    @Override
    public org.springframework.data.domain.Sort.Order toElasticsearchSortOrder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
