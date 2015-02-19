package net.sghill.rescuebuddies.files;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;

public class UriCopier implements Copier {
    @Override
    public void copy(URI from, URI to) {
        String[] split = from.toString().split("!");
        URI uri = URI.create(split[0]);
        try (FileSystem fileSystem = FileSystems.newFileSystem(uri, new HashMap<String, String>())) {
            Path path = fileSystem.getPath(split[1]);
            Files.walkFileTree(path, RecursiveCopyingFileVisitor.fromURI(to));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
