package net.sghill.rescuebuddies.acceptance;

import com.google.common.io.Resources;
import net.sghill.rescuebuddies.files.ClasspathExtractor;
import org.robotframework.RobotFramework;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class Runner {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Path target = new Runner().relocateAcceptanceTests();
        RobotFramework.main(new String[]{"run", target.toString()});
    }

    public Path relocateAcceptanceTests() throws IOException, URISyntaxException {
        String temp = System.getProperty("java.io.tmpdir");
        final Path target = Paths.get(temp, UUID.randomUUID().toString(), "Acceptance");
        URI source = Resources.getResource("acceptance").toURI();
        new ClasspathExtractor().extractFromArchive(source, target.toUri());
        return target;
    }
}
