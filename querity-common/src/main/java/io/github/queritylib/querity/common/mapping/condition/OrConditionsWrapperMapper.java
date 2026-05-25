package io.github.queritylib.querity.common.mapping.condition;

import io.github.queritylib.querity.api.Condition;
import io.github.queritylib.querity.api.OrConditionsWrapper;
import io.github.queritylib.querity.common.mapping.PropertyNameMapper;
import java.util.stream.Collectors;

class OrConditionsWrapperMapper implements ConditionMapper<OrConditionsWrapper> {

    @Override
    public boolean canMap(Condition condition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OrConditionsWrapper mapCondition(OrConditionsWrapper condition, PropertyNameMapper propertyNameMapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
