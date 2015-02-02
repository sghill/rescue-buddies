package net.sghill.rescuebuddies;

import io.dropwizard.db.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

public class RescueBuddiesDatabaseConfiguration {
    private final static Logger log = LoggerFactory.getLogger(RescueBuddiesDatabaseConfiguration.class);

    public static DataSourceFactory create(String databaseUrl) {
        DataSourceFactory database = new DataSourceFactory();
        try {
            URI dbUri = new URI(databaseUrl);
            if ("postgres".equals(dbUri.getScheme())) {
                String user = dbUri.getUserInfo().split(":")[0];
                String password = dbUri.getUserInfo().split(":")[1];
                String url = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
                database.setUser(user);
                database.setPassword(password);
                database.setUrl(url);
                database.setDriverClass("org.postgresql.Driver");
            } else if ("h2:mem:".equals(dbUri.getSchemeSpecificPart())) {
                database.setUrl(databaseUrl);
                database.setDriverClass("org.h2.Driver");
                database.setUser("");
                database.setPassword("");
            } else {
                throw new IllegalArgumentException("DATABASE_URL provided, but database is unsupported");
            }
        } catch (URISyntaxException e) {
            log.info(e.getMessage());
            throw new IllegalArgumentException("DATABASE_URL could not be parsed");
        }
        return database;
    }
}