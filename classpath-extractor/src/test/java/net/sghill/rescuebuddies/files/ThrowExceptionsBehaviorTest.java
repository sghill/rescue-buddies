package net.sghill.rescuebuddies.files;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class ThrowExceptionsBehaviorTest {
    private Behavior behavior = Behavior.THROW_EXCEPTIONS;

    @Test
    public void shouldThrowExceptionsOnError() {
        // Given
        Set<Error> errors = new HashSet<>();
        errors.add(new Error("Some problem"));
        errors.add(new Error("Yet another problem"));

        try {
            // When
            behavior.handle(errors);
            fail();
        } catch (RuntimeException e) {
            // Then
            assertThat(e.getMessage()).isEqualTo("Errors:\n\tSome problem\n\tYet another problem");
        }
    }

    @Test
    public void shouldNotThrowExceptionWithoutError() {
        // When
        behavior.handle(new HashSet<Error>());

        // Then no exception
    }

    @Test
    public void shouldNotThrowExceptionOnNull() {
        // When
        behavior.handle(null);

        // Then no exception
    }
}
