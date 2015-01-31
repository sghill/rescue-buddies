package net.sghill.rescuebuddies.client;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.JacksonConverter;

@Module(library = true)
public class RescueBuddiesClientModule {

    @Provides RestAdapter providesRescueBuddiesService() {
        return new RestAdapter.Builder()
                .setEndpoint("http://localhost:8686")
                .setClient(new OkClient())
                .setConverter(new JacksonConverter())
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .build();
    }

    @Provides RescueBuddiesService providesRescueBuddiesService(RestAdapter adapter) {
        return adapter.create(RescueBuddiesService.class);
    }
}
