package io.github.queritylib.querity.jpa;

import io.github.queritylib.querity.api.AdvancedQuery;
import io.github.queritylib.querity.api.Condition;
import io.github.queritylib.querity.api.Querity;
import io.github.queritylib.querity.api.Query;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

public class QuerityJpaImpl implements Querity {

    private final EntityManager entityManager;

    public QuerityJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass, Query query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Long count(Class<T> entityClass, Condition condition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Map<String, Object>> findAllProjected(Class<?> entityClass, AdvancedQuery query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected <T> JpaQueryFactory<T> getJpaQueryFactory(Class<T> entityClass, Query query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected <T> JpaAdvancedQueryFactory<T> getJpaAdvancedQueryFactory(Class<T> entityClass, AdvancedQuery query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
