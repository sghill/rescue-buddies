package net.sghill.rescuebuddies.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
public class FosterParent {
    private final UUID id;
    private final String name;

    public FosterParent(@JsonProperty("id") UUID id,
                        @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
