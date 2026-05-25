package io.github.queritylib.querity.jpa;

import io.github.queritylib.querity.api.Query;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.persistence.metamodel.Metamodel;
import java.util.List;
import java.util.stream.Stream;

/**
 * Factory for creating JPA queries from Query objects.
 * Handles simple entity queries with filter, sort, and pagination.
 *
 * @param <T> the entity type
 */
public class JpaQueryFactory<T> {

    private final Class<T> entityClass;

    private final Query query;

    private final EntityManager entityManager;

    JpaQueryFactory(Class<T> entityClass, Query query, EntityManager entityManager) {
        this.entityClass = entityClass;
        this.query = query;
        this.entityManager = entityManager;
    }

    /**
     * Create a JPA TypedQuery&lt;Tuple&gt; based on the provided Query object.
     * The query will include filters, sorting, and pagination as specified in the Query.
     * The tuple contains the root entity and the additional fields for sorting;
     * the root entity is always included as the first element of the tuple.
     *
     * @return A TypedQuery that can be executed to retrieve results.
     */
    public TypedQuery<Tuple> getJpaQuery() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Apply selections to the CriteriaQuery.
     * If there are sorting orders, they are added as selections to ensure they are included in the result set.
     * The root entity is always included as the first selection.
     */
    private void applySelections(CriteriaQuery<Tuple> cq, Root<T> root) {
        List<Selection<?>> selections = Stream.concat(Stream.of(root), cq.getOrderList().stream().<Selection<?>>map(Order::getExpression)).toList();
        cq.multiselect(selections);
    }

    public TypedQuery<Long> getJpaCountQuery() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void applySelectCount(Root<T> root, CriteriaQuery<Long> cq, CriteriaBuilder cb) {
        // always counting distinct rows, should not be a problem since there's no sorting
        cq.select(cb.countDistinct(root));
    }

    private <R> TypedQuery<R> createTypedQuery(CriteriaQuery<R> cq) {
        return entityManager.createQuery(cq);
    }
}
