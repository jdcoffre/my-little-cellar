package org.jdcoffre.mlc.server.data;

import org.jdcoffre.mlc.server.api.Cellar;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class DataPersisterTest {

    @Test
    public void persistJsonCellar() throws IOException {
        DataPersister dataPersister = new DataPersister(System.getProperty("user.dir") + "/target");
        dataPersister.persist(new Cellar("cellarTest"));

        File cellarFile = new File("target", "cellarTest.json");
        assertTrue(cellarFile.exists());
    }
}
