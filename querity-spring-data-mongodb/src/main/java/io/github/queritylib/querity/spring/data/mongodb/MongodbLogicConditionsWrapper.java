package io.github.queritylib.querity.spring.data.mongodb;

import io.github.queritylib.querity.api.LogicConditionsWrapper;
import io.github.queritylib.querity.api.LogicOperator;
import lombok.experimental.Delegate;
import org.springframework.data.mongodb.core.query.Criteria;

abstract class MongodbLogicConditionsWrapper extends MongodbCondition {

    @Delegate
    private final LogicConditionsWrapper conditionsWrapper;

    protected MongodbLogicConditionsWrapper(LogicConditionsWrapper conditionsWrapper) {
        this.conditionsWrapper = conditionsWrapper;
    }

    @Override
    public <T> Criteria toCriteria(Class<T> entityClass, boolean negate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <T> Criteria[] buildConditionsCriteria(Class<T> entityClass, boolean negate) {
        return getConditions().stream().map(MongodbCondition::of).map(c -> c.toCriteria(entityClass, negate)).toArray(Criteria[]::new);
    }
}
