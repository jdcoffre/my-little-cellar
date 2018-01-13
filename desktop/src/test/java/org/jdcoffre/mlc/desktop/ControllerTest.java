package org.jdcoffre.mlc.desktop;

import org.jdcoffre.mlc.lib.MLCExecption;
import org.jdcoffre.mlc.lib.MyLittleCellar;
import org.jdcoffre.mlc.lib.data.Cellar;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ControllerTest {

    @Test
    public void addNewCellar() throws MLCExecption {
        MyLittleCellar mlc = mock(MyLittleCellar.class);
        Controller controller = new Controller(mlc);

        controller.addCellar("addNewCellar");

        verify(mlc,times(1)).addCellar(any(Cellar.class));
    }

    @Test (expected = MLCExecption.class)
    public void cannotAddTwiceTheSameCellar() throws MLCExecption {
        MyLittleCellar mlc = mock(MyLittleCellar.class);
        doThrow(new MLCExecption("")).when(mlc).addCellar(any(Cellar.class));
        Controller controller = new Controller(mlc);

        controller.addCellar("addNewCellar");
    }
}