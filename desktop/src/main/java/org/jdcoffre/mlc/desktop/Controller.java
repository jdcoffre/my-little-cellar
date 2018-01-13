package org.jdcoffre.mlc.desktop;

import org.jdcoffre.mlc.lib.MLCExecption;
import org.jdcoffre.mlc.lib.MyLittleCellar;
import org.jdcoffre.mlc.lib.data.Cellar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {

    private final MyLittleCellar mlc;

    public Controller(final MyLittleCellar mlc) {
        this.mlc = mlc;
    }

    public void addCellar(String cellarName) throws MLCExecption {
        mlc.addCellar(new Cellar(cellarName));
    }

    public List<String> getCellarNames() {
        List<String> cellars = new ArrayList<>();
        for (Cellar cellar: mlc.getCellars()) {
            cellars.add(cellar.getName());
        }

        Collections.sort(cellars);

        return cellars;
    }
}
