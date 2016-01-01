package org.jdcoffre.mlc.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class MlcConfiguration extends Configuration {

    @NotEmpty
    private String dataFolder = "./data";


    @JsonProperty
    public String getDataFolder() {
        return dataFolder;
    }

    @JsonProperty
    public void setDataFolder(String dataFolder) {
        this.dataFolder = dataFolder;
    }

}
