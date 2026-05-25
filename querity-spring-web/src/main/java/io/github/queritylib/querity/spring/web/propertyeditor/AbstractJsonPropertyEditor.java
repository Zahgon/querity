package io.github.queritylib.querity.spring.web.propertyeditor;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;
import org.springframework.core.GenericTypeResolver;
import org.springframework.util.StringUtils;
import java.beans.PropertyEditorSupport;

public abstract class AbstractJsonPropertyEditor<T> extends PropertyEditorSupport {

    private final ObjectMapper objectMapper;

    protected AbstractJsonPropertyEditor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private Class<T> getPropertyClass() {
        return (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractJsonPropertyEditor.class);
    }
}
