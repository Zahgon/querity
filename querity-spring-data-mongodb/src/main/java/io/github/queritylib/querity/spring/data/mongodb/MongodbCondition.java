package io.github.queritylib.querity.spring.data.mongodb;

import io.github.queritylib.querity.api.Condition;
import org.springframework.data.mongodb.core.query.Criteria;
import java.util.Set;
import static io.github.queritylib.querity.common.util.ConditionUtils.getConditionImplementation;
import static io.github.queritylib.querity.common.util.ReflectionUtils.findSubclasses;

abstract class MongodbCondition {

    public <T> Criteria toCriteria(Class<T> entityClass) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract <T> Criteria toCriteria(Class<T> entityClass, boolean negate);

    private static final Set<Class<? extends MongodbCondition>> MONGODB_CONDITION_IMPLEMENTATIONS = findSubclasses(MongodbCondition.class);

    public static MongodbCondition of(Condition condition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
