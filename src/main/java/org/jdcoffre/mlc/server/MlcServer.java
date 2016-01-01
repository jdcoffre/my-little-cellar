package org.jdcoffre.mlc.server;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdcoffre.mlc.server.resource.Bottles;

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
        // nothing to do yet
    }

    @Override
    public void run(MlcConfiguration mlcConfiguration, Environment environment) throws Exception {
        final Bottles bottlesResource = new Bottles();
        environment.jersey().register(bottlesResource   );
    }
}
