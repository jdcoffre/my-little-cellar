package org.jdcoffre.mlc.server.db;


import com.google.common.collect.Lists;
import org.jdcoffre.mlc.server.data.Bottle;
import org.jdcoffre.mlc.server.data.Cellar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseMock implements Database {

    final Map<String,Cellar> cellarMap = new HashMap<>();
    final Map<String,Bottle> bottleMap = new HashMap<>();

    @Override
    public void addCellar(Cellar cellar) {
        cellarMap.put(cellar.getName(), cellar);
    }

    @Override
    public Cellar getCellar(String name) {
        return cellarMap.get(name);
    }

    @Override
    public List<Cellar> getCellars() {
        return Lists.newArrayList(cellarMap.values());
    }

    @Override
    public boolean exist(Cellar cellar) {
        return cellarMap.containsKey(cellar.getName());
    }

    @Override
    public void addBottle(Bottle bottle) {
        bottleMap.put(getID(bottle),bottle);
    }

    private String getID(Bottle bottle) {
        return bottle.getName();
    }

    @Override
    public Bottle getBottle(String bottleId) {
        return bottleMap.get(bottleId);
    }

    @Override
    public List<Bottle> getBottles() {
        return Lists.newArrayList(bottleMap.values());
    }

    @Override
    public boolean exist(Bottle bottle) {
        return bottleMap.containsKey(getID(bottle));
    }
}
