package io.github.queritylib.querity.spring.web.jackson;

import io.github.queritylib.querity.api.Condition;
import io.github.queritylib.querity.api.FunctionArgument;
import io.github.queritylib.querity.api.GroupBy;
import io.github.queritylib.querity.api.PropertyExpression;
import io.github.queritylib.querity.api.Select;
import io.github.queritylib.querity.api.Sort;
import tools.jackson.databind.BeanDescription;
import tools.jackson.databind.DeserializationConfig;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.deser.Deserializers;

class QuerityDeserializers extends Deserializers.Base {

    @Override
    public ValueDeserializer<?> findBeanDeserializer(JavaType type, DeserializationConfig config, BeanDescription.Supplier beanDescSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean hasDeserializerFor(DeserializationConfig config, Class<?> valueType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
