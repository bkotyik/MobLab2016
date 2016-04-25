package bkotyik.mobsoft2016.presenter;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.interactor.FloorInteractor;
import bkotyik.mobsoft2016.view.MainView;

public class MainPresenter extends Presenter<MainView> {

    @Inject
    public FloorInteractor interactor;

    public MainPresenter() {

    }

    public void doStuff() {
        view.showFloors(interactor.getFloors());
    }
}
