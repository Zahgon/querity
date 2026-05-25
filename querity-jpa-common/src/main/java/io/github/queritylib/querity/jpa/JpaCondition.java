package io.github.queritylib.querity.jpa;

import io.github.queritylib.querity.api.Condition;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.Metamodel;
import java.util.Set;
import static io.github.queritylib.querity.common.util.ConditionUtils.getConditionImplementation;
import static io.github.queritylib.querity.common.util.ReflectionUtils.findSubclasses;

abstract class JpaCondition {

    public abstract <T> Predicate toPredicate(Class<T> entityClass, Metamodel metamodel, Root<T> root, CriteriaQuery<?> cq, CriteriaBuilder cb);

    private static final Set<Class<? extends JpaCondition>> JPA_CONDITION_IMPLEMENTATIONS = findSubclasses(JpaCondition.class);

    public static JpaCondition of(Condition condition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
