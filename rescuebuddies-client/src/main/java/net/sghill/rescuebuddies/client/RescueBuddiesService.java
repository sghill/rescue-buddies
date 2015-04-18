package net.sghill.rescuebuddies.client;

import net.sghill.rescuebuddies.api.Buddy;
import net.sghill.rescuebuddies.api.FosterParent;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.PUT;
import retrofit.http.Path;

import java.util.Collection;
import java.util.UUID;

public interface RescueBuddiesService {

    @GET("/buddies")
    Collection<Buddy> fetchBuddies();

    @PUT("/foster-parents/{id}")
    Response createFosterParent(@Path("id") UUID id, @Body FosterParent fosterParent);
}
