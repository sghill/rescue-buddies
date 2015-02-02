package net.sghill.rescuebuddies;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import net.sghill.rescuebuddies.jdbi.BuddiesDAO;
import net.sghill.rescuebuddies.resources.BuddiesResource;
import org.skife.jdbi.v2.DBI;

public class RescueBuddiesApplication extends Application<RescueBuddiesConfiguration> {
    public static void main(String... args) throws Exception {
        new RescueBuddiesApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<RescueBuddiesConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<RescueBuddiesConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(RescueBuddiesConfiguration configuration) {
                return configuration.getDatabaseConfiguration();
            }
        });
        bootstrap.addBundle(new DBIExceptionsBundle());
    }

    @Override
    public void run(RescueBuddiesConfiguration config, Environment environment) throws Exception {
        DBIFactory factory = new DBIFactory();
        DBI jdbi = factory.build(environment, config.getDatabaseConfiguration(), config.dbName());
        BuddiesDAO buddiesDAO = jdbi.onDemand(BuddiesDAO.class);
        environment.jersey().register(new BuddiesResource(buddiesDAO));
    }
}
