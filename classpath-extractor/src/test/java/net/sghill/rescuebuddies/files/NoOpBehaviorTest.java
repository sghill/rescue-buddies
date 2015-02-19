package net.sghill.rescuebuddies.files;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class NoOpBehaviorTest {
    private Behavior behavior = Behavior.NO_OP;

    @Test
    public void shouldNotThrowExceptionOnError() {
        // Given
        Set<Error> errors = new HashSet<>();
        errors.add(new Error("Some problem"));

        // When
        behavior.handle(errors);

        // Then no exception
    }

    @Test
    public void shouldNotThrowExceptionWithoutError() {
        // When
        behavior.handle(new HashSet<Error>());

        // Then
    }

    @Test
    public void shouldNotThrowOnNull() {
        // When
        behavior.handle(null);

        // Then no exception
    }
}
