package org.jdcoffre.mlc.server;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.jdcoffre.mlc.server.db.Database;
import org.jdcoffre.mlc.server.db.DatabaseMock;
import org.jdcoffre.mlc.server.resource.Bottles;

public class MlcServer extends Application<Configuration> {

    public static final String MLC_NAME = "My Little Cellar";
    private static final Database dataBase = new DatabaseMock();

    public static void main(String[] args) throws Exception {
        new MlcServer().run(args);
    }

    @Override
    public String getName() {
        return MLC_NAME;
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new ViewBundle<Configuration>());
    }

    @Override
    public void run(Configuration mlcConfiguration, Environment environment) throws Exception {
        final Bottles bottlesResource = new Bottles(dataBase);
        environment.jersey().register(bottlesResource);
    }
}
