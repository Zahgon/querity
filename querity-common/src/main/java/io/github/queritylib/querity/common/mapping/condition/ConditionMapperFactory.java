package io.github.queritylib.querity.common.mapping.condition;

import io.github.queritylib.querity.api.Condition;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConditionMapperFactory {

    private static final List<ConditionMapper<?>> CONDITION_MAPPERS = Arrays.asList(new SimpleConditionMapper(), new AndConditionsWrapperMapper(), new OrConditionsWrapperMapper(), new NotConditionMapper());

    @SuppressWarnings("unchecked")
    public static <C extends Condition> ConditionMapper<C> getConditionMapper(C condition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
