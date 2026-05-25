package io.github.queritylib.querity.common.mapping.condition;

import io.github.queritylib.querity.api.Condition;
import io.github.queritylib.querity.api.SimpleCondition;
import io.github.queritylib.querity.common.mapping.PropertyNameMapper;

class SimpleConditionMapper implements ConditionMapper<SimpleCondition> {

    @Override
    public boolean canMap(Condition condition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleCondition mapCondition(SimpleCondition condition, PropertyNameMapper propertyNameMapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
