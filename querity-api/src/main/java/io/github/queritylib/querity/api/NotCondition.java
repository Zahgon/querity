package io.github.queritylib.querity.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Builder(toBuilder = true)
@Jacksonized
@Getter
@EqualsAndHashCode
@ToString
public class NotCondition implements Condition {

    @NonNull
    @JsonProperty("not")
    private Condition condition;

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
