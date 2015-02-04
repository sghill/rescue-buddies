package net.sghill.rescuebuddies.client;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.JacksonConverter;

@Module(library = true)
public class RescueBuddiesClientModule {

    @Provides RestAdapter.Builder providesRescueBuddiesService() {
        return new RestAdapter.Builder()
                .setClient(new OkClient())
                .setConverter(new JacksonConverter())
                .setLogLevel(RestAdapter.LogLevel.BASIC);
    }

    @Provides RescueBuddiesService providesRescueBuddiesService(RestAdapter.Builder adapter) {
        return adapter
                .setEndpoint(serviceEndpoint())
                .build()
                .create(RescueBuddiesService.class);
    }

    @Provides RescueBuddiesAdminService providesRescueBuddiesAdminService(RestAdapter.Builder adapter) {
        return adapter
                .setEndpoint(adminServiceEndpoint())
                .build()
                .create(RescueBuddiesAdminService.class);
    }

    private Endpoint serviceEndpoint() {
        String baseUrl = System.getProperty("rb.service.baseUrl", "");
        return Endpoints.newFixedEndpoint(baseUrl);
    }

    private Endpoint adminServiceEndpoint() {
        String baseUrl = System.getProperty("rb.adminService.baseUrl", "");
        return Endpoints.newFixedEndpoint(baseUrl);
    }
}
