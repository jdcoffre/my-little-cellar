package org.jdcoffre.mlc.lib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdcoffre.mlc.lib.data.Cellar;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MyLittleCellar {

    private static final Logger logger = LogManager.getLogger(MyLittleCellar.class);
    private Map<String,Cellar> cellars = new HashMap<>();

    public void addCellar(Cellar cellar) throws MLCExecption {
        if(cellars.containsKey(cellar.getName())){
            throw new MLCExecption("You cannot add twice the same cellar!");
        }
        cellars.put(cellar.getName(), cellar);
    }


    public Collection<Cellar> getCellars() {
        return cellars.values();
    }
}
