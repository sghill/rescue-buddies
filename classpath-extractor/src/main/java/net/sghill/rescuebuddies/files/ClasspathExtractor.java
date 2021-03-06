package net.sghill.rescuebuddies.files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Objects;
import java.util.Set;

public class ClasspathExtractor {
    private static final Logger LOG = LoggerFactory.getLogger(ClasspathExtractor.class);
    private final UriValidator validator;
    private final ValidationHandler handler;
    private final Copier copier;

    public ClasspathExtractor() {
        this(new JarUriValidator(), Behavior.NO_OP, new UriCopier());
    }

    public ClasspathExtractor(UriValidator validator, ValidationHandler handler, Copier copier) {
        this.validator = validator;
        this.handler = handler;
        this.copier = copier;
    }

    public void extractFromArchive(URI source, URI destination) {
        Objects.requireNonNull(source, "Source URI must not be null");
        Objects.requireNonNull(destination, "Destination URI must not be null");
        Set<Error> errors = validator.validate(source);
        handler.handle(errors);
        copier.copy(source, destination);
        LOG.info("Copied '{}' to '{}'", source, destination);
    }
}
