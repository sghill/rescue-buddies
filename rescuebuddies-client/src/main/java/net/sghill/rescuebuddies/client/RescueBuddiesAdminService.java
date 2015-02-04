package net.sghill.rescuebuddies.client;

import net.sghill.rescuebuddies.api.admin.HealthCheck;
import retrofit.client.Response;
import retrofit.http.GET;

import java.util.Map;

public interface RescueBuddiesAdminService {

    @GET("/ping")
    Response ping();

    @GET("/healthcheck")
    Map<String, HealthCheck> fetchHealthCheck();
}
