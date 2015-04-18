package net.sghill.rescuebuddies.acceptance.libraries;

import net.sghill.rescuebuddies.api.FosterParent;
import net.sghill.rescuebuddies.client.RescueBuddiesService;
import retrofit.client.Response;

import javax.inject.Inject;
import java.util.UUID;

public class FosterParentLibrary extends InjectableLibrary {
    @Inject
    RescueBuddiesService service;

    public Response createFosterParent(UUID id, String name) {
        return service.createFosterParent(id, new FosterParent(id, name));
    }
}
