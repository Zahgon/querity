package io.github.queritylib.querity.jpa;

import io.github.queritylib.querity.api.NativeSelectWrapper;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;
import jakarta.persistence.metamodel.Metamodel;
import java.util.ArrayList;
import java.util.List;

/**
 * JPA-specific native select wrapper that supports {@link SelectionSpecification}.
 * This allows users to create native JPA selections using a lambda that receives
 * the Root and CriteriaBuilder at query execution time.
 */
public class JpaSelectionSpecificationSelectWrapper extends JpaNativeSelectWrapper<SelectionSpecification<?>> {

    public JpaSelectionSpecificationSelectWrapper(NativeSelectWrapper<SelectionSpecification<?>> nativeSelectWrapper) {
        super(nativeSelectWrapper);
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Selection<?>> toSelections(Metamodel metamodel, Root<?> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<String> getPropertyNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
