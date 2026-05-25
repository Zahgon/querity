package io.github.queritylib.querity.spring.web;

import tools.jackson.databind.ObjectMapper;
import io.github.queritylib.querity.api.AdvancedQuery;
import io.github.queritylib.querity.api.Condition;
import io.github.queritylib.querity.api.Query;
import io.github.queritylib.querity.spring.web.propertyeditor.AdvancedQueryJsonPropertyEditor;
import io.github.queritylib.querity.spring.web.propertyeditor.ConditionJsonPropertyEditor;
import io.github.queritylib.querity.spring.web.propertyeditor.QueryJsonPropertyEditor;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.lang.NonNull;
import org.springframework.validation.Validator;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class QuerityWebMvcSupport extends WebMvcConfigurationSupport {

    private final ObjectMapper objectMapper;

    public QuerityWebMvcSupport(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    @NonNull
    protected ConfigurableWebBindingInitializer getConfigurableWebBindingInitializer(@NonNull FormattingConversionService mvcConversionService, @NonNull Validator mvcValidator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
