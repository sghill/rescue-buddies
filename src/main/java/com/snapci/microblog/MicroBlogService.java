package com.snapci.microblog;

import com.snapci.microblog.jdbi.MicroBlogDAO;
import com.snapci.microblog.jdbi.UserDAO;
import com.snapci.microblog.resources.MicroBlogResource;
import com.snapci.microblog.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class MicroBlogService extends Application<MicroBlogConfiguration> {
    public static void main(String... args) throws Exception {
        new MicroBlogService().run(args);
    }

    @Override
    public void initialize(Bootstrap<MicroBlogConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<MicroBlogConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(MicroBlogConfiguration configuration) {
                return configuration.getDatabaseConfiguration();
            }
        });
        bootstrap.addBundle(new DBIExceptionsBundle());
    }

    @Override
    public void run(MicroBlogConfiguration config, Environment environment) throws Exception {
        DBIFactory factory = new DBIFactory();
        DBI jdbi = factory.build(environment, config.getDatabaseConfiguration(), "postgresql");
        UserDAO userDAO = jdbi.onDemand(UserDAO.class);
        environment.jersey().register(new UserResource(userDAO));
        MicroBlogDAO microBlogDAO = jdbi.onDemand(MicroBlogDAO.class);
        environment.jersey().register(new MicroBlogResource(microBlogDAO, userDAO));
    }
}
