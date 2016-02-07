package org.jdcoffre.mlc.server.view;

import io.dropwizard.views.View;
import org.jdcoffre.mlc.server.api.Grape;
import org.jdcoffre.mlc.server.api.WineType;

import java.util.ArrayList;
import java.util.List;

public class BottleForm extends View {
    public BottleForm() {
        super("BottleForm.ftl");
    }

    public List<String> getWineTypes(){
        final List<String> types = new ArrayList<>();
        for(WineType type : WineType.values()){
            types.add(type.toString().toLowerCase());
        }

        return types;
    }

    public List<String> getGrapes(){
        final List<String> grapes = new ArrayList<>();
        for(Grape grape : Grape.values()){
            grapes.add(grape.toString().toLowerCase());
        }

        return grapes;
    }
}
