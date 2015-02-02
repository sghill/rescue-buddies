package net.sghill.rescuebuddies;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class RescueBuddiesConfiguration extends Configuration {

    @JsonProperty
    private Db db;

    public DataSourceFactory getDatabaseConfiguration() {
        return RescueBuddiesDatabaseConfiguration.create(resolveDbUrl());
    }

    public String dbName() {
        return db.name;
    }

    private String resolveDbUrl() {
        return MoreObjects.firstNonNull(System.getenv("DATABASE_URL"), db.url);
    }

    private static class Db {
        @JsonProperty String url;
        @JsonProperty String name;
    }
}
