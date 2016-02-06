package org.jdcoffre.mlc.server.db;


import org.jdcoffre.mlc.server.api.Bottle;

import java.util.List;

public interface Database {

    void addBottle(Bottle bottle);

    Bottle getBottle(String bottleId);

    List<Bottle> getBottles();

    boolean exist(Bottle bottle);
}
