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

    @Provides RescueBuddiesService providesRescueBuddiesService(RestAdapter.Builder adapter, Endpoint endpoint) {
        return adapter
                .setEndpoint(endpoint)
                .build()
                .create(RescueBuddiesService.class);
    }

    @Provides RescueBuddiesAdminService providesRescueBuddiesAdminService(RestAdapter.Builder adapter) {
        String baseUrl = System.getProperty("rb.adminService.baseUrl", "");
        return adapter
                .setEndpoint(Endpoints.newFixedEndpoint(baseUrl))
                .build()
                .create(RescueBuddiesAdminService.class);
    }

    @Provides Endpoint providesServiceEndpoint() {
        String baseUrl = System.getProperty("rb.service.baseUrl", "");
        return Endpoints.newFixedEndpoint(baseUrl);
    }

}
