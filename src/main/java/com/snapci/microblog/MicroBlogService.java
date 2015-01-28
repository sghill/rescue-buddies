package com.snapci.microblog;

import io.dropwizard.Application;
import io.dropwizard.db.DatabaseConfiguration;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MicroBlogService extends Application<MicroBlogConfiguration> {
    public static void main(String... args) throws Exception {
        new MicroBlogService().run(args);
    }

    @Override
    public void initialize(Bootstrap<MicroBlogConfiguration> bootstrap) {

    }

    @Override
    public void run(MicroBlogConfiguration configuration, Environment environment) throws Exception {

    }

//    @Override
//    public void initialize(Bootstrap bootstrap) {
//        bootstrap.setName("microblog");
//        bootstrap.addBundle(new MigrationsBundle<MicroBlogConfiguration>() {
//            @Override
//            public DatabaseConfiguration getDatabaseConfiguration(MicroBlogConfiguration config) {
//                return config.getDatabaseConfiguration();
//            }
//        });
//        bootstrap.addBundle(new DBIExceptionsBundle());
//    }


//    @Override
//    public void run(MicroBlogConfiguration config, Environment environment) throws Exception {
//        DBIFactory factory = new DBIFactory();
//        DBI jdbi = factory.build(environment, config.getDatabaseConfiguration(), "postgresql");
//        UserDAO userDAO = jdbi.onDemand(UserDAO.class);
//        environment.addResource(new UserResource(userDAO));
//        MicroBlogDAO microBlogDAO = jdbi.onDemand(MicroBlogDAO.class);
//        environment.addResource(new MicroBlogResource(microBlogDAO, userDAO));
//    }
}
