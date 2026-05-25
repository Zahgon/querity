package io.github.queritylib.querity.jpa;

import io.github.queritylib.querity.api.PropertyExpression;
import io.github.queritylib.querity.api.SimpleSort;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.Metamodel;
import lombok.experimental.Delegate;

class JpaSimpleSort extends JpaSort {

    @Delegate
    private final SimpleSort simpleSort;

    public JpaSimpleSort(SimpleSort simpleSort) {
        this.simpleSort = simpleSort;
    }

    @Override
    public <T> Order toOrder(Metamodel metamodel, Root<T> root, CriteriaBuilder cb) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
