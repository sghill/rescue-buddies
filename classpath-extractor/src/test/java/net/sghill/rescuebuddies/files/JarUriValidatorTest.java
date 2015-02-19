package net.sghill.rescuebuddies.files;

import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class JarUriValidatorTest {
    private JarUriValidator validator;

    @Before
    public void setUp() {
        validator = new JarUriValidator();
    }

    @Test
    public void shouldNotErrorOnJarUri() {
        // Given
        URI jarUri = URI.create("jar:file:/usr/local/tmp.jar!some/file.txt");

        // When
        Set<Error> errors = validator.validate(jarUri);

        // Then
        assertThat(errors).isEmpty();
    }

    @Test
    public void shouldErrorOnNonJarUri() {
        // Given
        URI nonJarUri = URI.create("file:///usr/local/file.txt");

        // When
        Set<Error> errors = validator.validate(nonJarUri);

        // Then
        assertThat(errors).containsOnly(new Error("URI is not a valid jar path"));
    }
}
