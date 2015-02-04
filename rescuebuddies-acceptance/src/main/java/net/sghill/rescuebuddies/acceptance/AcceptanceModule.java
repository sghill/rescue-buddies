package net.sghill.rescuebuddies.acceptance;

import dagger.Module;
import net.sghill.rescuebuddies.acceptance.libraries.AdminLibrary;
import net.sghill.rescuebuddies.acceptance.libraries.BuddyLibrary;
import net.sghill.rescuebuddies.client.RescueBuddiesClientModule;

@Module(
        includes = RescueBuddiesClientModule.class,
        injects = {
                AdminLibrary.class,
                BuddyLibrary.class,
        }
)
public class AcceptanceModule {
}
