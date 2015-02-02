package net.sghill.rescuebuddies.acceptance.libraries;

import net.sghill.rescuebuddies.api.Buddy;
import net.sghill.rescuebuddies.client.RescueBuddiesService;

import javax.inject.Inject;
import java.util.Collection;

public class BuddyLibrary extends InjectableLibrary {
    @Inject
    RescueBuddiesService service;

    public Collection<Buddy> fetchBuddies() {
        return service.fetchBuddies();
    }
}
