package net.sghill.rescuebuddies.acceptance.libraries;

import dagger.ObjectGraph;
import net.sghill.rescuebuddies.acceptance.AcceptanceModule;

public class InjectableLibrary {
    public InjectableLibrary() {
        ObjectGraph.create(new AcceptanceModule()).inject(this);
    }
}
