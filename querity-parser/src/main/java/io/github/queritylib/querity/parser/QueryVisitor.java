package io.github.queritylib.querity.parser;

import io.github.queritylib.querity.api.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class QueryVisitor extends QueryParserBaseVisitor<Object> {

    @Override
    public QueryDefinition visitQuery(QueryParser.QueryContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitWhereCondition(QueryParser.WhereConditionContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitSelectClause(QueryParser.SelectClauseContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitSelectFields(QueryParser.SelectFieldsContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitSelectField(QueryParser.SelectFieldContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitGroupByClause(QueryParser.GroupByClauseContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitGroupByFields(QueryParser.GroupByFieldsContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitHavingClause(QueryParser.HavingClauseContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitPropertyExpression(QueryParser.PropertyExpressionContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String visitPropertyName(QueryParser.PropertyNameContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitFunctionCall(QueryParser.FunctionCallContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitNullaryFunction(QueryParser.NullaryFunctionContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitFunctionName(QueryParser.FunctionNameContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FunctionArgument visitFunctionArg(QueryParser.FunctionArgContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitPaginationParams(QueryParser.PaginationParamsContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitCondition(QueryParser.ConditionContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Condition visitConditionWrapper(QueryParser.ConditionWrapperContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitNotCondition(QueryParser.NotConditionContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Condition visitSimpleCondition(QueryParser.SimpleConditionContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitSimpleValue(QueryParser.SimpleValueContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitArrayValue(QueryParser.ArrayValueContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitOperator(QueryParser.OperatorContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitSortFields(QueryParser.SortFieldsContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitSortField(QueryParser.SortFieldContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object visitDirection(QueryParser.DirectionContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static String unescapeBacktickProperty(String text) {
        String raw = text.substring(1, text.length() - 1);
        StringBuilder result = new StringBuilder(raw.length());
        boolean escaped = false;
        for (int i = 0; i < raw.length(); i++) {
            char current = raw.charAt(i);
            if (escaped) {
                result.append(current);
                escaped = false;
            } else if (current == '\\' && i + 1 < raw.length()) {
                escaped = true;
            } else {
                result.append(current);
            }
        }
        return result.toString();
    }

    /**
     * Extracts property names from a list of PropertyExpressions.
     * <p>Assumes all expressions are PropertyReference instances.
     *
     * @param expressions list of PropertyExpression (must all be PropertyReference)
     * @return array of property names
     */
    private static String[] extractPropertyNames(List<PropertyExpression> expressions) {
        return expressions.stream().map(PropertyReference.class::cast).map(PropertyReference::getPropertyName).toArray(String[]::new);
    }
}
