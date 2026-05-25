package io.github.queritylib.querity.api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public interface Querity {

    <T> List<T> findAll(Class<T> entityClass, Query query);

    <T> Long count(Class<T> entityClass, Condition condition);

    /**
     * Execute a projection query returning a list of maps with the selected properties.
     *
     * @param entityClass the entity class to query
     * @param query the advanced query with select, groupBy, and having clauses
     * @return a list of maps containing the selected properties
     */
    default List<Map<String, Object>> findAllProjected(Class<?> entityClass, AdvancedQuery query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static Query.QueryBuilder query() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create an advanced query builder for projection queries.
     *
     * <p>Use this for queries that require SELECT, GROUP BY, or HAVING clauses:
     * <pre>{@code
     * AdvancedQuery query = Querity.advancedQuery()
     *     .select(prop("category"), sum(prop("amount")).as("total"))
     *     .filter(filterBy("status", EQUALS, "ACTIVE"))
     *     .groupBy("category")
     *     .having(filterBy(count(prop("id")), GREATER_THAN, 10))
     *     .build();
     *
     * List<Map<String, Object>> results = querity.findAllProjected(Order.class, query);
     * }</pre>
     *
     * @return an AdvancedQuery builder
     * @see #query() for simple entity queries
     */
    static AdvancedQuery.AdvancedQueryBuilder advancedQuery() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Filter by propertyName EQUALS value
     *
     * @param propertyName the property name
     * @param value        the value
     * @return a SimpleCondition with {@link Operator#EQUALS}
     */
    static SimpleCondition filterBy(String propertyName, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static SimpleCondition filterBy(String propertyName, Operator operator, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static SimpleCondition filterBy(String propertyName, Operator operator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> NativeConditionWrapper<T> filterByNative(T nativeCondition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static AndConditionsWrapper and(Condition... conditions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static OrConditionsWrapper or(Condition... conditions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static NotCondition not(Condition condition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static Pagination paged(Integer page, Integer pageSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static SimpleSort sortBy(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static SimpleSort sortBy(String propertyName, SimpleSort.Direction direction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> NativeSortWrapper<T> sortByNative(T nativeSort) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static SimpleSelect selectBy(String... propertyNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SafeVarargs
    static <T> NativeSelectWrapper<T> selectByNative(T... nativeSelections) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a GROUP BY clause with the given property names.
     *
     * <p>Example:
     * <pre>{@code
     * AdvancedQuery query = Querity.advancedQuery()
     *     .select(
     *         prop("category"),
     *         sum(prop("amount")).as("totalAmount")
     *     )
     *     .groupBy("category")
     *     .build();
     * }</pre>
     *
     * @param propertyNames the property names to group by
     * @return a SimpleGroupBy
     */
    static SimpleGroupBy groupBy(String... propertyNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a GROUP BY clause with the given expressions.
     *
     * <p>Example:
     * <pre>{@code
     * AdvancedQuery query = Querity.advancedQuery()
     *     .select(
     *         upper(prop("category")).as("upperCategory"),
     *         sum(prop("amount")).as("totalAmount")
     *     )
     *     .groupByExpressions(upper(prop("category")))
     *     .build();
     * }</pre>
     *
     * @param expressions the expressions to group by
     * @return a SimpleGroupBy
     */
    static SimpleGroupBy groupBy(PropertyExpression... expressions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static Query wrapConditionInQuery(Condition condition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a reference to a field for use in field-to-field comparisons.
     *
     * <p>Example:
     * <pre>{@code
     * // Compare startDate < endDate
     * Querity.filterByField("startDate", Operator.LESSER_THAN, Querity.field("endDate"))
     *
     * // Nested fields are supported
     * Querity.filterByField("address.city", Operator.EQUALS, Querity.field("billingAddress.city"))
     * }</pre>
     *
     * @param fieldName the name of the field to reference (supports nested paths like "address.city")
     * @return a FieldReference for use as a value in SimpleCondition
     * @see FieldReference
     * @see #filterByField(String, Operator, FieldReference)
     */
    static FieldReference field(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Filter by comparing one field against another field.
     *
     * <p>This enables queries like "find all records where startDate is before endDate"
     * or "find all products where salePrice is less than originalPrice".
     *
     * <p>Example:
     * <pre>{@code
     * // Find products on sale (salePrice < originalPrice)
     * Query query = Querity.query()
     *     .filter(Querity.filterByField("salePrice", Operator.LESSER_THAN, Querity.field("originalPrice")))
     *     .build();
     *
     * // Nested fields are supported
     * Query query = Querity.query()
     *     .filter(Querity.filterByField("shipping.city", Operator.NOT_EQUALS, Querity.field("billing.city")))
     *     .build();
     * }</pre>
     *
     * <p><b>Note:</b> Not all operators support field-to-field comparison. Supported operators are:
     * {@code EQUALS}, {@code NOT_EQUALS}, {@code GREATER_THAN}, {@code GREATER_THAN_EQUALS},
     * {@code LESSER_THAN}, {@code LESSER_THAN_EQUALS}.
     *
     * <p><b>Backend support:</b> JPA and MongoDB support this feature. Elasticsearch does not.
     *
     * @param propertyName the property name on the left side (supports nested paths)
     * @param operator the comparison operator
     * @param fieldReference reference to the field on the right side
     * @return a SimpleCondition comparing two fields
     * @throws IllegalArgumentException if the operator does not support field references
     * @see FieldReference
     * @see #field(String)
     */
    static SimpleCondition filterByField(String propertyName, Operator operator, FieldReference fieldReference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ==================== Property Expression Methods ====================
    /**
     * Create a property reference for use in expressions.
     *
     * @param propertyName the property name (supports nested paths like "address.city")
     * @return a PropertyReference
     * @see PropertyReference
     */
    static PropertyReference property(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Alias for {@link #property(String)} - creates a property reference for use in expressions.
     *
     * <p>This shorter name improves readability when using static imports:
     * <pre>{@code
     * import static io.github.queritylib.querity.api.Querity.*;
     *
     * // Instead of:
     * upper(property("lastName"))
     *
     * // You can write:
     * upper(prop("lastName"))
     * }</pre>
     *
     * @param propertyName the property name (supports nested paths like "address.city")
     * @return a PropertyReference
     * @see #property(String)
     */
    static PropertyReference prop(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a string literal for use in function arguments.
     *
     * <p>Example:
     * <pre>{@code
     * import static io.github.queritylib.querity.api.Querity.*;
     *
     * // Concatenate with literal separator
     * concat(prop("firstName"), lit(" - "), prop("lastName"))
     *
     * // Default value in coalesce
     * coalesce(prop("nickname"), lit("Anonymous"))
     * }</pre>
     *
     * @param value the string literal value
     * @return a Literal wrapping the string
     * @see Literal
     */
    static Literal lit(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a number literal for use in function arguments.
     *
     * <p>Example:
     * <pre>{@code
     * import static io.github.queritylib.querity.api.Querity.*;
     *
     * // Modulo with literal divisor
     * mod(prop("value"), lit(10))
     * }</pre>
     *
     * @param value the number literal value
     * @return a Literal wrapping the number
     * @see Literal
     */
    static Literal lit(Number value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a boolean literal for use in function arguments.
     *
     * <p>Example:
     * <pre>{@code
     * import static io.github.queritylib.querity.api.Querity.*;
     *
     * // Default value in coalesce
     * coalesce(prop("isActive"), lit(false))
     * }</pre>
     *
     * @param value the boolean literal value
     * @return a Literal wrapping the boolean
     * @see Literal
     */
    static Literal lit(Boolean value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Filter by a property expression with an operator and value.
     *
     * <p>Example:
     * <pre>{@code
     * // Filter where UPPER(lastName) = "SKYWALKER"
     * Querity.filterBy(Querity.upper(Querity.property("lastName")), Operator.EQUALS, "SKYWALKER")
     *
     * // Filter where LENGTH(name) > 5
     * Querity.filterBy(Querity.length(Querity.property("name")), Operator.GREATER_THAN, 5)
     * }</pre>
     *
     * @param expression the property expression (function call or property reference)
     * @param operator the comparison operator
     * @param value the value to compare against
     * @return a SimpleCondition with the expression
     */
    static SimpleCondition filterBy(PropertyExpression expression, Operator operator, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Filter by a property expression with an operator (for IS_NULL, IS_NOT_NULL).
     *
     * @param expression the property expression
     * @param operator the operator (IS_NULL or IS_NOT_NULL)
     * @return a SimpleCondition with the expression
     */
    static SimpleCondition filterBy(PropertyExpression expression, Operator operator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sort by a property expression.
     *
     * <p>Example:
     * <pre>{@code
     * // Sort by LENGTH(lastName) ascending
     * Querity.sortBy(Querity.length(Querity.property("lastName")))
     *
     * // Sort by UPPER(firstName) descending
     * Querity.sortBy(Querity.upper(Querity.property("firstName")), SimpleSort.Direction.DESC)
     * }</pre>
     *
     * @param expression the property expression to sort by
     * @return a SimpleSort with default ASC direction
     */
    static SimpleSort sortBy(PropertyExpression expression) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sort by a property expression with specified direction.
     *
     * @param expression the property expression to sort by
     * @param direction the sort direction
     * @return a SimpleSort with the expression
     */
    static SimpleSort sortBy(PropertyExpression expression, SimpleSort.Direction direction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Select by property expressions.
     *
     * <p>Example:
     * <pre>{@code
     * // Select with functions
     * Querity.selectBy(
     *     Querity.upper(Querity.property("firstName")),
     *     Querity.length(Querity.property("lastName")),
     *     Querity.property("email")
     * )
     * }</pre>
     *
     * @param expressions the expressions to select
     * @return a SimpleSelect with the expressions
     */
    static SimpleSelect selectBy(PropertyExpression... expressions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ==================== Function Factory Methods ====================
    /**
     * Create a generic function call.
     *
     * @param function the function to call
     * @param arguments the arguments (use {@link #prop(String)} for properties, {@link #lit} for literals)
     * @return a FunctionCall
     */
    static FunctionCall function(Function function, FunctionArgument... arguments) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --- Arithmetic Functions ---
    /**
     * ABS function - returns the absolute value of a numeric expression.
     *
     * @param argument the numeric expression (use {@link #prop(String)} for properties)
     * @return a FunctionCall for ABS
     */
    static FunctionCall abs(FunctionArgument argument) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * SQRT function - returns the square root of a numeric expression.
     *
     * @param argument the numeric expression (use {@link #prop(String)} for properties)
     * @return a FunctionCall for SQRT
     */
    static FunctionCall sqrt(FunctionArgument argument) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * MOD function - returns the remainder of division.
     *
     * @param dividend the dividend (use {@link #prop(String)} for properties, {@link #lit} for literals)
     * @param divisor the divisor (use {@link #prop(String)} for properties, {@link #lit} for literals)
     * @return a FunctionCall for MOD
     */
    static FunctionCall mod(FunctionArgument dividend, FunctionArgument divisor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --- String Functions ---
    /**
     * CONCAT function - concatenates strings.
     *
     * @param arguments the strings to concatenate (use {@link #prop(String)} for properties, {@link #lit} for literals)
     * @return a FunctionCall for CONCAT
     */
    static FunctionCall concat(FunctionArgument... arguments) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * SUBSTRING function - extracts a substring.
     *
     * @param string the string expression (use {@link #prop(String)} for properties)
     * @param start the start position (1-based)
     * @param length the length of the substring
     * @return a FunctionCall for SUBSTRING
     */
    static FunctionCall substring(FunctionArgument string, int start, int length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * TRIM function - removes leading and trailing whitespace.
     *
     * @param argument the string expression (use {@link #prop(String)} for properties)
     * @return a FunctionCall for TRIM
     */
    static FunctionCall trim(FunctionArgument argument) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * LTRIM function - removes leading whitespace.
     *
     * @param argument the string expression (use {@link #prop(String)} for properties)
     * @return a FunctionCall for LTRIM
     */
    static FunctionCall ltrim(FunctionArgument argument) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * RTRIM function - removes trailing whitespace.
     *
     * @param argument the string expression (use {@link #prop(String)} for properties)
     * @return a FunctionCall for RTRIM
     */
    static FunctionCall rtrim(FunctionArgument argument) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * LOWER function - converts a string to lowercase.
     *
     * @param argument the string expression (use {@link #prop(String)} for properties)
     * @return a FunctionCall for LOWER
     */
    static FunctionCall lower(FunctionArgument argument) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * UPPER function - converts a string to uppercase.
     *
     * @param argument the string expression (use {@link #prop(String)} for properties)
     * @return a FunctionCall for UPPER
     */
    static FunctionCall upper(FunctionArgument argument) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * LENGTH function - returns the length of a string.
     *
     * @param argument the string expression (use {@link #prop(String)} for properties)
     * @return a FunctionCall for LENGTH
     */
    static FunctionCall length(FunctionArgument argument) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * LOCATE function - returns the position of a substring within a string.
     *
     * @param search the substring to search for (use {@link #prop(String)} for properties, {@link #lit} for literals)
     * @param string the string to search in (use {@link #prop(String)} for properties)
     * @return a FunctionCall for LOCATE
     */
    static FunctionCall locate(FunctionArgument search, FunctionArgument string) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --- Date/Time Functions ---
    /**
     * CURRENT_DATE function - returns the current date.
     *
     * @return a FunctionCall for CURRENT_DATE
     */
    static FunctionCall currentDate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * CURRENT_TIME function - returns the current time.
     *
     * @return a FunctionCall for CURRENT_TIME
     */
    static FunctionCall currentTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * CURRENT_TIMESTAMP function - returns the current timestamp.
     *
     * @return a FunctionCall for CURRENT_TIMESTAMP
     */
    static FunctionCall currentTimestamp() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --- Conditional Functions ---
    /**
     * COALESCE function - returns the first non-null argument.
     *
     * @param arguments the arguments to check (use {@link #prop(String)} for properties, {@link #lit} for literals)
     * @return a FunctionCall for COALESCE
     */
    static FunctionCall coalesce(FunctionArgument... arguments) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * NULLIF function - returns null if the two arguments are equal, otherwise returns the first.
     *
     * @param value1 the first value (use {@link #prop(String)} for properties, {@link #lit} for literals)
     * @param value2 the second value (use {@link #prop(String)} for properties, {@link #lit} for literals)
     * @return a FunctionCall for NULLIF
     */
    static FunctionCall nullif(FunctionArgument value1, FunctionArgument value2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --- Aggregate Functions ---
    /**
     * COUNT function - counts non-null values.
     * <p><b>Note:</b> Aggregate functions can only be used in projections.
     *
     * @param argument the expression to count (use {@link #prop(String)} for properties)
     * @return a FunctionCall for COUNT
     */
    static FunctionCall count(FunctionArgument argument) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * SUM function - returns the sum of numeric values.
     * <p><b>Note:</b> Aggregate functions can only be used in projections.
     *
     * @param argument the numeric expression to sum (use {@link #prop(String)} for properties)
     * @return a FunctionCall for SUM
     */
    static FunctionCall sum(FunctionArgument argument) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * AVG function - returns the average of numeric values.
     * <p><b>Note:</b> Aggregate functions can only be used in projections.
     *
     * @param argument the numeric expression to average (use {@link #prop(String)} for properties)
     * @return a FunctionCall for AVG
     */
    static FunctionCall avg(FunctionArgument argument) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * MIN function - returns the minimum value.
     * <p><b>Note:</b> Aggregate functions can only be used in projections.
     *
     * @param argument the expression to find the minimum of (use {@link #prop(String)} for properties)
     * @return a FunctionCall for MIN
     */
    static FunctionCall min(FunctionArgument argument) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * MAX function - returns the maximum value.
     * <p><b>Note:</b> Aggregate functions can only be used in projections.
     *
     * @param argument the expression to find the maximum of (use {@link #prop(String)} for properties)
     * @return a FunctionCall for MAX
     */
    static FunctionCall max(FunctionArgument argument) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
