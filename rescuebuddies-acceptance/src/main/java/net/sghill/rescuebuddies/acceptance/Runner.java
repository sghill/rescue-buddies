package net.sghill.rescuebuddies.acceptance;

import com.google.common.io.Resources;
import org.robotframework.RobotFramework;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.UUID;

public class Runner {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Path target = new Runner().relocateAcceptanceTests();
        System.out.println(target);
        RobotFramework.run(new String[] { "run", target.toString() });
    }

    public Path relocateAcceptanceTests() throws IOException, URISyntaxException {

        String temp = System.getProperty("java.io.tmpdir");
        final Path target = Paths.get(temp, UUID.randomUUID().toString(), "Acceptance");


        URI uri = Resources.getResource("acceptance").toURI();
        String[] split = uri.toString().split("!");
        try (FileSystem fileSystem = FileSystems.newFileSystem(URI.create(split[0]), new HashMap<String, String>())) {
            Path path = fileSystem.getPath(split[1]);
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                private Path currentHead = target;

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    Path directoryToCreate = Paths.get(dir.getFileName().toString()); // avoid filesystem mismatch
                    currentHead = currentHead.resolve(directoryToCreate);
                    Files.createDirectories(currentHead);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Path fileToCreate = Paths.get(file.getFileName().toString());
                    Files.copy(file, currentHead.resolve(fileToCreate));
                    return FileVisitResult.CONTINUE;
                }
            });
        }
        return target;
    }
}
