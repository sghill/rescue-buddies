package net.sghill.rescuebuddies.acceptance;

import dagger.Module;
import dagger.Provides;
import net.sghill.rescuebuddies.acceptance.libraries.BuddyLibrary;
import net.sghill.rescuebuddies.acceptance.libraries.LifecycleLibrary;
import net.sghill.rescuebuddies.client.RescueBuddiesClientModule;

import javax.inject.Singleton;

@Module(
        includes = RescueBuddiesClientModule.class,
        injects = {
                BuddyLibrary.class,
                LifecycleLibrary.class
        }
)
public class AcceptanceModule {
    @Provides @Singleton AppProcess providesAppProcess() {
        return new AppProcess();
    }
}
