package org.jdcoffre.mlc.server.resource;

import org.jdcoffre.mlc.server.api.Bottle;
import org.jdcoffre.mlc.server.db.Database;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class BottlesTest {

    private Database db = mock(Database.class);
    private Bottles bottlesResource = new Bottles(db);

    @Before
    public void initMock(){
        reset(db);
    }

    @Test
    public void createABottle() throws IOException {
        when(db.exist(any(Bottle.class))).thenReturn(false);
        Bottle bottle = new Bottle();

        Response response = bottlesResource.postBottle(bottle);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        verify(db).addBottle(bottle);
    }

    @Test
    public void createABottleThatAlreadyExist() throws IOException {
        when(db.exist(any(Bottle.class))).thenReturn(true);

        Response response = bottlesResource.postBottle(new Bottle());
        assertEquals(Response.Status.CONFLICT.getStatusCode(), response.getStatus());
    }

    @Test
    public void getAllBottles() throws IOException {
        when(db.getBottles()).thenReturn(Collections.singletonList(new Bottle()));

        List<Bottle> bottles = bottlesResource.getBottles();
        assertNotNull(bottles);
        assertEquals(1, bottles.size());
        verify(db).getBottles();
    }

}
