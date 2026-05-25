package io.github.queritylib.querity.common.mapping.condition;

import io.github.queritylib.querity.api.AndConditionsWrapper;
import io.github.queritylib.querity.api.Condition;
import io.github.queritylib.querity.common.mapping.PropertyNameMapper;
import java.util.stream.Collectors;

class AndConditionsWrapperMapper implements ConditionMapper<AndConditionsWrapper> {

    @Override
    public boolean canMap(Condition condition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AndConditionsWrapper mapCondition(AndConditionsWrapper condition, PropertyNameMapper propertyNameMapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
