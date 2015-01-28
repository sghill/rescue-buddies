package com.snapci.microblog;

import io.dropwizard.db.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

public class MicroBlogDatabaseConfiguration {
    final static Logger logger = LoggerFactory.getLogger(MicroBlogDatabaseConfiguration.class);

    public static DataSourceFactory create(String databaseUrl) {
        if (databaseUrl == null) {
            throw new IllegalArgumentException("The DATABASE_URL environment variable must be set before running the app " +
                    "example: DATABASE_URL=\"postgres://sahilm:sahilm@localhost:5432/microblog\"");
        }
        DataSourceFactory databaseConfiguration = null;
        try {
            URI dbUri = new URI(databaseUrl);
            String user = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String url = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
            databaseConfiguration = new DataSourceFactory();
            databaseConfiguration.setUser(user);
            databaseConfiguration.setPassword(password);
            databaseConfiguration.setUrl(url);
            databaseConfiguration.setDriverClass("org.postgresql.Driver");
        } catch (URISyntaxException e) {
            logger.info(e.getMessage());
        }
        return databaseConfiguration;
    }
}