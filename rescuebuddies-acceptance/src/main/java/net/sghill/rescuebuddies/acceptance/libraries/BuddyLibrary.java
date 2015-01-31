package net.sghill.rescuebuddies.acceptance.libraries;

import com.google.common.io.Resources;
import net.sghill.rescuebuddies.api.Buddy;
import net.sghill.rescuebuddies.client.RescueBuddiesService;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Collection;

public class BuddyLibrary extends InjectableLibrary {
    @Inject
    RescueBuddiesService service;

    public Collection<Buddy> fetchBuddies() {
        String applicationJar = "C:/users/steve/documents/rescue-buddies/rescuebuddies-application/target/rescuebuddies-application-0.0.1-SNAPSHOT.jar";

        String path = Resources.getResource("acceptance.yml").getPath();
        try {
            String format = String.format("java -jar %s server %s", applicationJar, path);
            System.out.println(format);
            final Process exec = Runtime.getRuntime().exec(format);
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override public void run() {
                    exec.destroy();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return service.fetchBuddies();
    }
}
