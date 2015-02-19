package net.sghill.rescuebuddies.files;

import java.util.Set;

public enum Behavior implements ValidationHandler {
    THROW_EXCEPTIONS {
        @Override
        public void handle(Set<Error> errors) {
            if (errors == null || errors.isEmpty()) {
                return;
            }
            StringBuilder sb = new StringBuilder("Errors:");
            for (Error error : errors) {
                sb.append("\n\t").append(error.getReason());
            }
            throw new RuntimeException(sb.toString());
        }
    },
    NO_OP {
        @Override
        public void handle(Set<Error> errors) {
            // do nothing
        }
    }
}
