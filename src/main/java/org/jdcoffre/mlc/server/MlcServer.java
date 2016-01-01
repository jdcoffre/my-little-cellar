package org.jdcoffre.mlc.server;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.jdcoffre.mlc.server.data.DataPersister;
import org.jdcoffre.mlc.server.resource.Bottles;
import org.jdcoffre.mlc.server.resource.Cellars;
import org.jdcoffre.mlc.server.resource.Racks;
import org.jdcoffre.mlc.server.resource.Webapp;

public class MlcServer extends Application<MlcConfiguration> {

    public static final String MLC_NAME = "My Little Cellar";

    public static void main(String[] args) throws Exception {
        new MlcServer().run(args);
    }

    @Override
    public String getName() {
        return MLC_NAME;
    }

    @Override
    public void initialize(Bootstrap<MlcConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle<MlcConfiguration>());
    }

    @Override
    public void run(MlcConfiguration mlcConfiguration, Environment environment) throws Exception {
        final DataPersister dataPersister = new DataPersister(mlcConfiguration.getDataFolder());
        final Bottles bottlesResource = new Bottles(dataPersister);
        environment.jersey().register(bottlesResource);
        final Cellars cellarsResource = new Cellars(dataPersister);
        environment.jersey().register(cellarsResource);
        final Racks racksResource = new Racks(dataPersister);
        environment.jersey().register(racksResource);

        environment.jersey().register(new Webapp());
    }
}
