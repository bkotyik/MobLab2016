package bkotyik.mobsoft2016.interactor;

import javax.inject.Inject;

import bkotyik.mobsoft2016.MVPApplication;
import bkotyik.mobsoft2016.model.StringModel;

public class StringInteractor {
    @Inject
    StringModel model;

    public StringInteractor() {
        MVPApplication.injector.inject(this);
    }

    public String getString() {
        return model.getNextString();
    }
}
