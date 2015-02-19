package net.sghill.rescuebuddies.files;

import java.net.URI;
import java.util.Set;

public interface UriValidator {
    Set<Error> validate(URI uri);
}
