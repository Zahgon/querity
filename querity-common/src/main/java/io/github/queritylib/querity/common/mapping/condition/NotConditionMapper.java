package io.github.queritylib.querity.common.mapping.condition;

import io.github.queritylib.querity.api.Condition;
import io.github.queritylib.querity.api.NotCondition;
import io.github.queritylib.querity.common.mapping.PropertyNameMapper;

class NotConditionMapper implements ConditionMapper<NotCondition> {

    @Override
    public boolean canMap(Condition condition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public NotCondition mapCondition(NotCondition condition, PropertyNameMapper propertyNameMapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
