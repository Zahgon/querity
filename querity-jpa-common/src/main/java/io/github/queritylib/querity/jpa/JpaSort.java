package io.github.queritylib.querity.jpa;

import io.github.queritylib.querity.api.NativeSortWrapper;
import io.github.queritylib.querity.api.SimpleSort;
import io.github.queritylib.querity.api.Sort;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.Metamodel;
import java.util.Optional;
import java.util.Set;
import static io.github.queritylib.querity.common.util.ReflectionUtils.findSubclasses;
import static io.github.queritylib.querity.common.util.SortUtils.getSortImplementation;

abstract class JpaSort {

    private static final Set<Class<? extends JpaSort>> JPA_SORT_IMPLEMENTATIONS = findSubclasses(JpaSort.class);

    public abstract <T> Order toOrder(Metamodel metamodel, Root<T> root, CriteriaBuilder cb);

    @SuppressWarnings("unchecked")
    public static JpaSort of(Sort sort) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
