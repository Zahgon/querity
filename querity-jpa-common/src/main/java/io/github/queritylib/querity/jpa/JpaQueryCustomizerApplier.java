package io.github.queritylib.querity.jpa;

import io.github.queritylib.querity.api.QueryCustomizer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

final class JpaQueryCustomizerApplier {

    private JpaQueryCustomizerApplier() {
        throw new UnsupportedOperationException("Utility class");
    }

    static <T> void apply(EntityManager entityManager, Class<T> entityClass, TypedQuery<?> typedQuery, List<QueryCustomizer<?>> customizers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
