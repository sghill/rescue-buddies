package net.sghill.rescuebuddies.acceptance;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AppProcess {
    private static final String APP = MoreObjects.firstNonNull(System.getProperty("app"), Paths.get("target", "rescuebuddies.jar").toString());
    private static final String CONFIG = Resources.getResource("acceptance.yml").getPath();
    private static final Path JAVA = Paths.get(System.getProperty("java.home"), "bin", "java");
    private static final List<String> START = Lists.newArrayList(JAVA.toString(), "-jar", APP, "server", CONFIG);
    private static final List<String> MIGRATE = Lists.newArrayList(JAVA.toString(), "-jar", APP, "db", "migrate", CONFIG);
    private Process process;

    public void start() {
        Preconditions.checkArgument(process == null);
        Preconditions.checkArgument(Files.exists(Paths.get(APP)));
        try {
            process = new ProcessBuilder(START).inheritIO().start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void migrateDb() {
        Preconditions.checkArgument(process != null);
        try {
            process = new ProcessBuilder(MIGRATE).inheritIO().start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        if (process == null) {
            return;
        }
        process.destroy();
    }
}
