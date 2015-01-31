package net.sghill.rescuebuddies.client;

import net.sghill.rescuebuddies.api.Buddy;
import retrofit.http.GET;

import java.util.Collection;

public interface RescueBuddiesService {

    @GET("/buddies")
    Collection<Buddy> fetchBuddies();
}
