package org.jdcoffre.mlc.desktop;

import org.jdcoffre.mlc.lib.MLCExecption;
import org.jdcoffre.mlc.lib.MyLittleCellar;
import org.jdcoffre.mlc.lib.data.Cellar;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    public void getAllCellarNames(){
        MyLittleCellar mlc = mock(MyLittleCellar.class);
        List<Cellar> cellars = new ArrayList<>();
        when(mlc.getCellars()).thenReturn(cellars);

        Controller controller = new Controller(mlc);
        assertThat(controller.getCellarNames(), empty());

        cellars.add(new Cellar("test1"));
        cellars.add(new Cellar("test2"));
        assertThat(controller.getCellarNames(), hasItem("test1"));
        assertThat(controller.getCellarNames(), hasItem("test2"));
        assertThat(controller.getCellarNames().size(), equalTo(2));
    }
}