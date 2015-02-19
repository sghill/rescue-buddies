package net.sghill.rescuebuddies.files;

import java.util.Set;

public interface ValidationHandler {
    void handle(Set<Error> errors);
}
