package net.sghill.rescuebuddies.acceptance.libraries;

import net.sghill.rescuebuddies.acceptance.AppProcess;

import javax.inject.Inject;

public class LifecycleLibrary extends InjectableLibrary {
    @Inject AppProcess app;

    public void startApplication() {
        app.start();
    }

    public void applyDatabaseMigrations() {
        app.migrateDb();
    }

    public void stopApplication() {
        app.stop();
    }
}
