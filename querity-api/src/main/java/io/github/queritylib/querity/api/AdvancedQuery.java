package io.github.queritylib.querity.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents an advanced query with projection, grouping, and aggregation capabilities.
 *
 * <p>Use this class for queries that require:
 * <ul>
 *   <li>Projections - selecting specific fields or computed values</li>
 *   <li>Grouping - GROUP BY clauses</li>
 *   <li>Aggregations - COUNT, SUM, AVG, etc. with HAVING filters</li>
 * </ul>
 *
 * <p>Use with {@link Querity#findAllProjected(Class, AdvancedQuery)} which returns
 * {@code List<Map<String, Object>>} instead of entities.
 *
 * <h2>Example Usage</h2>
 * <pre>{@code
 * AdvancedQuery query = Querity.advancedQuery()
 *     .select(
 *         prop("category"),
 *         sum(prop("amount")).as("totalAmount"),
 *         count(prop("id")).as("orderCount")
 *     )
 *     .filter(filterBy("status", EQUALS, "COMPLETED"))
 *     .groupBy("category")
 *     .having(filterBy(count(prop("id")), GREATER_THAN, 10))
 *     .sort(sortBy("totalAmount", DESC))
 *     .build();
 *
 * List<Map<String, Object>> report = querity.findAllProjected(Order.class, query);
 * }</pre>
 *
 * @see Query for simple entity queries
 * @see QueryDefinition for the common query interface
 */
@Builder(toBuilder = true)
@Jacksonized
@Getter
@EqualsAndHashCode(of = { "filter", "pagination", "sort", "distinct", "select", "groupBy", "having" })
@ToString(of = { "filter", "pagination", "sort", "distinct", "select", "groupBy", "having" })
public class AdvancedQuery implements QueryDefinition {

    private final Condition filter;

    private final Pagination pagination;

    @NonNull
    private final Sort[] sort;

    private boolean distinct;

    private final Select select;

    @Setter(AccessLevel.NONE)
    private final GroupBy groupBy;

    private final Condition having;

    @NonNull
    @JsonIgnore
    private List<AdvancedQueryPreprocessor> preprocessors;

    @NonNull
    @JsonIgnore
    private List<QueryCustomizer<?>> customizers;

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

    public boolean hasSelect() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean hasGroupBy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean hasHaving() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Sort> getSort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Apply all registered preprocessors to this query.
     *
     * @return the preprocessed query
     */
    public AdvancedQuery preprocess() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class AdvancedQueryBuilder {

        @SuppressWarnings("java:S1068")
        private Pagination pagination;

        @SuppressWarnings({ "java:S1068", "java:S1450" })
        private Sort[] sort = new Sort[0];

        @SuppressWarnings("java:S1068")
        private Select select;

        @SuppressWarnings("java:S1068")
        private GroupBy groupBy;

        @SuppressWarnings("java:S1068")
        private Condition having;

        private List<AdvancedQueryPreprocessor> preprocessors = new ArrayList<>();

        private List<QueryCustomizer<?>> customizers = new ArrayList<>();

        /**
         * Adds a preprocessor to be applied when {@link AdvancedQuery#preprocess()} is called.
         *
         * @param preprocessor the preprocessor to add
         * @return this builder
         * @throws IllegalArgumentException if preprocessor is null
         */
        public AdvancedQueryBuilder withPreprocessor(AdvancedQueryPreprocessor preprocessor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public AdvancedQueryBuilder customize(QueryCustomizer<?>... customizers) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public AdvancedQueryBuilder sort(Sort... sort) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public AdvancedQueryBuilder pagination(Pagination pagination) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public AdvancedQueryBuilder pagination(Integer page, Integer pageSize) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @JsonSetter("select")
        public AdvancedQueryBuilder select(Select select) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public AdvancedQueryBuilder selectBy(String... propertyNames) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets the SELECT clause using expressions.
         * <p>Use this method for function-based projections:
         * <pre>{@code
         * advancedQuery()
         *     .select(prop("category"), sum(prop("amount")).as("total"))
         *     .build();
         * }</pre>
         *
         * @param expressions the expressions to select
         * @return this builder
         */
        @JsonIgnore
        public AdvancedQueryBuilder select(PropertyExpression... expressions) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets the GROUP BY clause directly using a GroupBy object.
         * <p>This method is typically used internally or for deserialization.
         * For fluent API usage, prefer {@link #groupBy(String...)} or {@link #groupByExpressions(PropertyExpression...)}.
         *
         * @param groupBy the GroupBy clause
         * @return this builder
         */
        @JsonSetter("groupBy")
        public AdvancedQueryBuilder groupBy(GroupBy groupBy) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets the GROUP BY clause using property names.
         * <p>This is the simplest and most concise way to group by columns:
         * <pre>{@code
         * advancedQuery().groupBy("category", "region").build();
         * }</pre>
         *
         * @param propertyNames the property names to group by
         * @return this builder
         * @see #groupByExpressions(PropertyExpression...) for function-based grouping
         */
        @JsonIgnore
        public AdvancedQueryBuilder groupBy(String... propertyNames) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets the GROUP BY clause using expressions.
         * <p>Use this method when you need function-based grouping:
         * <pre>{@code
         * advancedQuery()
         *     .groupByExpressions(upper(prop("category")), lower(prop("region")))
         *     .build();
         * }</pre>
         *
         * @param expressions the expressions to group by
         * @return this builder
         * @see #groupBy(String...) for simple property-based grouping
         */
        public AdvancedQueryBuilder groupByExpressions(PropertyExpression... expressions) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public AdvancedQueryBuilder having(Condition having) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Builds the query with semantic validation.
         *
         * @return the built AdvancedQuery
         * @throws IllegalStateException if HAVING is specified without GROUP BY
         */
        public AdvancedQuery build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
