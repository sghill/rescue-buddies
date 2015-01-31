package net.sghill.rescuebuddies;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class RescueBuddiesConfiguration extends Configuration {

    @JsonProperty
    private String dummy;

    @Valid
    @NotNull
    private DataSourceFactory database = RescueBuddiesDatabaseConfiguration.create(System.getenv("DATABASE_URL"));

    public DataSourceFactory getDatabaseConfiguration() {
        return database;
    }
}
