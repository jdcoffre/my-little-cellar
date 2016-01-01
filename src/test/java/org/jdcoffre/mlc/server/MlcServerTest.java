package org.jdcoffre.mlc.server;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MlcServerTest {

    @Test
    public void validateTheHTTPServerApplicationName(){
        MlcServer server = new MlcServer();
        assertEquals(MlcServer.MLC_NAME, server.getName());
    }

}
