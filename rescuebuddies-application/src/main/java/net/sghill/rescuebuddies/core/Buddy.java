package net.sghill.rescuebuddies.core;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.UUID;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Buddy {
    private final UUID id;
    private final String name;
    private final LocalDate birthDate;
    private final DateTime created;
    private final DateTime lastModified;
}
