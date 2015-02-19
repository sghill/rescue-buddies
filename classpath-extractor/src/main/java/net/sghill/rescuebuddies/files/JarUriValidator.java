package net.sghill.rescuebuddies.files;

import java.net.URI;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Validates the given URI is from within a jar.
 *
 * For example: <tt>jar:<url>!/[<entry>]</tt>
 */
public class JarUriValidator implements UriValidator {
    @Override
    public Set<Error> validate(URI uri) {
        Set<Error> errors = new HashSet<>();
        if(!Objects.toString(uri).contains("!")) {
            errors.add(new Error("URI is not a valid jar path"));
        }
        return errors;
    }
}
