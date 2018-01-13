package org.jdcoffre.mlc.desktop;

import org.jdcoffre.mlc.lib.MLCExecption;
import org.jdcoffre.mlc.lib.MyLittleCellar;
import org.jdcoffre.mlc.lib.data.Cellar;

public class Controller {

    private final MyLittleCellar mlc;

    public Controller(final MyLittleCellar mlc) {
        this.mlc = mlc;
    }

    public void addCellar(String cellarName) throws MLCExecption {
        mlc.addCellar(new Cellar(cellarName));
    }

}
