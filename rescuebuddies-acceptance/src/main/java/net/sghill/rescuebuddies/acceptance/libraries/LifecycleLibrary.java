package net.sghill.rescuebuddies.acceptance.libraries;

import net.sghill.rescuebuddies.acceptance.AppProcess;

import javax.inject.Inject;

public class LifecycleLibrary extends InjectableLibrary {
    @Inject AppProcess app;

    public void startApplication() {
        app.start();
        try {
            // server isn't starting on ci before test runs
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void applyDatabaseMigrations() {
        app.migrateDb();
    }

    public void stopApplication() {
        app.stop();
    }
}
