package org.jdcoffre.mlc.server.db;


import org.jdcoffre.mlc.server.data.Bottle;
import org.jdcoffre.mlc.server.data.Cellar;

import java.util.List;

public interface Database {

    // Cellars
    void setCellar(Cellar cellar);

    Cellar getCellar(String name);

    List<Cellar> getCellars();

    boolean exist(Cellar cellar);

    // Bottles
    void setBottle(Bottle bottle);

    List<Bottle> getBottles();

    boolean exist(Bottle bottle);
}
