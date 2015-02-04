package net.sghill.rescuebuddies.acceptance.libraries;

import net.sghill.rescuebuddies.client.RescueBuddiesAdminService;
import retrofit.client.Response;

import javax.inject.Inject;

public class AdminLibrary extends InjectableLibrary {
    @Inject
    RescueBuddiesAdminService adminService;

    public Response ping() {
        return adminService.ping();
    }
}
