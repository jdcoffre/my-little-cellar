package org.jdcoffre.mlc.server.data;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jdcoffre.mlc.server.api.Bottle;
import org.jdcoffre.mlc.server.api.Cellar;
import org.jdcoffre.mlc.server.api.Rack;

import java.io.File;
import java.io.IOException;

public class DataPersister {

    private static final String JSON_FILE_SUFFIX = ".json";
    private final File dataFolder;

    public DataPersister(final String dataFolder) {
        this.dataFolder = new File(dataFolder);
    }

    public void persist(Cellar cellar) throws IOException {
        final String fileContent = serialize(cellar);
        final String fileName = cellar.getName().concat(JSON_FILE_SUFFIX);

        FileUtils.serialize(dataFolder, fileContent, fileName);
    }

    public void persist(Rack rack) throws IOException {
        final String fileContent = serialize(rack);
        final String fileName = rack.getName().concat(JSON_FILE_SUFFIX);

        FileUtils.serialize(dataFolder, fileContent, fileName);
    }

    public void persist(final Bottle bottle) throws IOException {
        final String fileContent = serialize(bottle);
        final String fileName = bottle.getName().concat(JSON_FILE_SUFFIX);

        FileUtils.serialize(dataFolder, fileContent, fileName);
    }


    private String serialize(final Object obj) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.USE_GETTERS_AS_SETTERS);
        return mapper.writeValueAsString(obj);
    }
}
