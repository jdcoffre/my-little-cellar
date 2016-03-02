package org.jdcoffre.mlc.server.resource;

import org.jdcoffre.mlc.server.api.Cellar;
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
        verify(db).addCellar(cellar);
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

}
