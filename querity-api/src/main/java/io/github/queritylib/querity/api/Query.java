package io.github.queritylib.querity.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a simple query with filter, sort, and pagination capabilities.
 *
 * <p>Use this class for queries that return entities via {@link Querity#findAll(Class, Query)}.
 * For queries that require projections, grouping, or aggregations, use {@link AdvancedQuery}.
 *
 * <h2>Example Usage</h2>
 * <pre>{@code
 * Query query = Querity.query()
 *     .filter(filterBy("status", EQUALS, "ACTIVE"))
 *     .sort(sortBy("lastName", ASC))
 *     .pagination(0, 20)
 *     .build();
 *
 * List<Person> people = querity.findAll(Person.class, query);
 * }</pre>
 *
 * @see AdvancedQuery for projection queries with GROUP BY, SELECT, and HAVING
 * @see QueryDefinition for the common query interface
 */
@Builder(toBuilder = true)
@Jacksonized
@Getter
@EqualsAndHashCode(of = { "filter", "pagination", "sort", "distinct" })
@ToString(of = { "filter", "pagination", "sort", "distinct" })
public class Query implements QueryDefinition {

    private final Condition filter;

    private final Pagination pagination;

    @NonNull
    private final Sort[] sort;

    @NonNull
    @JsonIgnore
    private List<QueryPreprocessor> preprocessors;

    @NonNull
    @JsonIgnore
    private List<QueryCustomizer<?>> customizers;

    private boolean distinct;

    @Override
    public boolean hasFilter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean hasPagination() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean hasSort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Sort> getSort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class QueryBuilder {

        @SuppressWarnings("java:S1068")
        private Pagination pagination;

        @SuppressWarnings({ "java:S1068", "java:S1450" })
        private Sort[] sort = new Sort[0];

        private List<QueryPreprocessor> preprocessors = new ArrayList<>();

        private List<QueryCustomizer<?>> customizers = new ArrayList<>();

        public QueryBuilder withPreprocessor(QueryPreprocessor preprocessor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public QueryBuilder customize(QueryCustomizer<?>... customizers) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public QueryBuilder sort(Sort... sort) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public QueryBuilder pagination(Pagination pagination) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public QueryBuilder pagination(Integer page, Integer pageSize) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Query build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public Query preprocess() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
