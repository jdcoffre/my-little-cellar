package org.jdcoffre.mlc.server.services;

import org.jdcoffre.mlc.server.data.Bottle;
import org.jdcoffre.mlc.server.data.Cellar;
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

public class CellarsTest {

    private Database db = mock(Database.class);
    private Cellars cellarsResource = new Cellars(db);

    @Before
    public void initMock(){
        reset(db);
    }

    @Test
    public void createACellar() throws IOException {
        when(db.exist(any(Cellar.class))).thenReturn(false);
        Cellar cellar = new Cellar(1,1);

        Response response = cellarsResource.postCellar(cellar);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        verify(db).setCellar(cellar);
    }

    @Test
    public void createACellarThatAlreadyExist() throws IOException {
        when(db.exist(any(Cellar.class))).thenReturn(true);

        Response response = cellarsResource.postCellar(new Cellar(1,1));
        assertEquals(Response.Status.CONFLICT.getStatusCode(), response.getStatus());
    }

    @Test
    public void getAllCellars() throws IOException {
        when(db.getCellars()).thenReturn(Collections.singletonList(new Cellar(1,1)));

        List<Cellar> cellars = cellarsResource.getCellars();
        assertNotNull(cellars);
        assertEquals(1, cellars.size());
        verify(db).getCellars();
    }

    @Test
    public void setBottle() throws IOException {
        Bottle bottle = new Bottle();
        Cellar cellar = new Cellar(1,1);
        when(db.getCellar(anyString())).thenReturn(cellar);
        when(db.exist(bottle)).thenReturn(true);

        Response response = cellarsResource.setBottle("cellar", 0, 0 , bottle);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        verify(db).setCellar(cellar);
        assertEquals(bottle, cellar.getShelve(0).getBottle(0));
    }

}
