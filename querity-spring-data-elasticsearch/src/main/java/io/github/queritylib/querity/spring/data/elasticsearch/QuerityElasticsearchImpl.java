package io.github.queritylib.querity.spring.data.elasticsearch;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import io.github.queritylib.querity.api.AdvancedQuery;
import io.github.queritylib.querity.api.Condition;
import io.github.queritylib.querity.api.Querity;
import io.github.queritylib.querity.api.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.UncategorizedElasticsearchException;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class QuerityElasticsearchImpl implements Querity {

    private final ElasticsearchOperations elasticsearchOperations;

    public QuerityElasticsearchImpl(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
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
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findAllProjected(Class<?> entityClass, AdvancedQuery query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> sanitizeMap(Map<?, ?> source) {
        Map<String, Object> result = new LinkedHashMap<>();
        source.forEach((key, value) -> {
            if (key instanceof String strKey && !"_class".equals(strKey)) {
                result.put(strKey, value);
            }
        });
        return result;
    }

    private <T> org.springframework.data.elasticsearch.core.query.Query getElasticsearchQuery(Class<T> entityClass, Query query) {
        return getElasticsearchQueryFactory(entityClass, query).getElasticsearchQuery();
    }

    protected static <T> ElasticsearchQueryFactory<T> getElasticsearchQueryFactory(Class<T> entityClass, Query query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static <T> ElasticsearchAdvancedQueryFactory<T> getElasticsearchAdvancedQueryFactory(Class<T> entityClass, AdvancedQuery query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
