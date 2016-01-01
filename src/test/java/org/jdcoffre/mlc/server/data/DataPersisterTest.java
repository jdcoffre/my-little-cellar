package org.jdcoffre.mlc.server.data;

import org.jdcoffre.mlc.server.api.Bottle;
import org.jdcoffre.mlc.server.api.Cellar;
import org.jdcoffre.mlc.server.api.Rack;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class DataPersisterTest {

    @Test
    public void persistJsonBottle() throws IOException {
        DataPersister dataPersister = new DataPersister(System.getProperty("user.dir") + "/target");
        Bottle bottle = new Bottle();
        bottle.setName("bottleTest");
        dataPersister.persist(bottle);

        File cellarFile = new File("target", "bottleTest.json");
        assertTrue(cellarFile.exists());
    }

    @Test
    public void persistJsonCellar() throws IOException {
        DataPersister dataPersister = new DataPersister(System.getProperty("user.dir") + "/target");
        dataPersister.persist(new Cellar("cellarTest"));

        File cellarFile = new File("target", "cellarTest.json");
        assertTrue(cellarFile.exists());
    }

    @Test
    public void persistJsonRack() throws IOException {
        DataPersister dataPersister = new DataPersister(System.getProperty("user.dir") + "/target");
        Rack rack = new Rack();
        rack.setName("rackTest");
        dataPersister.persist(rack);

        File cellarFile = new File("target", "rackTest.json");
        assertTrue(cellarFile.exists());
    }
}
