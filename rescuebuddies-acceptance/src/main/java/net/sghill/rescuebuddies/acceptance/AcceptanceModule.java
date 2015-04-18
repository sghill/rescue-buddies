package net.sghill.rescuebuddies.acceptance;

import dagger.Module;
import net.sghill.rescuebuddies.acceptance.libraries.AdminLibrary;
import net.sghill.rescuebuddies.acceptance.libraries.BuddyLibrary;
import net.sghill.rescuebuddies.acceptance.libraries.FosterParentLibrary;
import net.sghill.rescuebuddies.acceptance.libraries.ResponseLibrary;
import net.sghill.rescuebuddies.client.RescueBuddiesClientModule;

@Module(
        includes = RescueBuddiesClientModule.class,
        injects = {
                AdminLibrary.class,
                BuddyLibrary.class,
                FosterParentLibrary.class,
                ResponseLibrary.class
        }
)
public class AcceptanceModule {
}
