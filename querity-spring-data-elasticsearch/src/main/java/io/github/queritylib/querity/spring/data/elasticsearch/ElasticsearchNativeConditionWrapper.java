package io.github.queritylib.querity.spring.data.elasticsearch;

import io.github.queritylib.querity.api.NativeConditionWrapper;
import lombok.experimental.Delegate;
import org.springframework.data.elasticsearch.core.query.Criteria;

class ElasticsearchNativeConditionWrapper extends ElasticsearchCondition {

    @Delegate
    private final NativeConditionWrapper<Criteria> nativeConditionWrapper;

    ElasticsearchNativeConditionWrapper(NativeConditionWrapper<Criteria> nativeConditionWrapper) {
        this.nativeConditionWrapper = nativeConditionWrapper;
    }

    @Override
    public <T> Criteria toCriteria(Class<T> entityClass, boolean negate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
