package net.sghill.rescuebuddies.files;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class ClasspathExtractorTest {
    @Mock
    private UriValidator uriValidator;
    @Mock
    private ValidationHandler validationHandler;
    @Mock
    private Copier copier;
    private ClasspathExtractor extractor;
    private static final URI DESTINATION = URI.create("/usr/local/fake");
    public static final URI SOURCE = URI.create("/usr/local/temp");

    @Before
    public void setUp() {
        initMocks(this);
        extractor = new ClasspathExtractor(uriValidator, validationHandler, copier);
    }

    @Test
    public void shouldValidateUriAndHandleResult() {
        // Given
        Set<Error> errors = new HashSet<>();
        errors.add(new Error("There was a problem"));
        given(uriValidator.validate(SOURCE)).willReturn(errors);

        // When
        extractor.extractFromArchive(SOURCE, DESTINATION);

        // Then
        verify(validationHandler).handle(errors);
        verify(copier).copy(SOURCE, DESTINATION);
    }

    // Why NPE? http://stackoverflow.com/a/8160
    @Test
    public void shouldThrowNPEOnNullSourceUri() {
        try {
            // When
            extractor.extractFromArchive(null, DESTINATION);
            fail();
        } catch (NullPointerException e) {
            // Then
            assertThat(e).hasMessage("Source URI must not be null");
        }
    }

    @Test
    public void shouldThrowNPEOnNullDestinationUri() {
        try {
            // When
            extractor.extractFromArchive(SOURCE, null);
            fail();
        } catch (NullPointerException e) {
            // Then
            assertThat(e).hasMessage("Destination URI must not be null");
        }
    }
}
