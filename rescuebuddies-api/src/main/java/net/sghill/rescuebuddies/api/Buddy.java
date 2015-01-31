package net.sghill.rescuebuddies.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
public class Buddy {
    private final UUID id;
    private final String name;
    private final String birthDate;
    private final String created;
    private final String lastModified;

    public Buddy(@JsonProperty("id") UUID id,
                 @JsonProperty("name") String name,
                 @JsonProperty("birthDate")  String birthDate,
                 @JsonProperty("created") String created,
                 @JsonProperty("lastModified") String lastModified) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.created = created;
        this.lastModified = lastModified;
    }
}
