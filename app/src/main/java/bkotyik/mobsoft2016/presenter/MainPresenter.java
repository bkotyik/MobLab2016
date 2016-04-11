package bkotyik.mobsoft2016.presenter;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.interactor.FloorInteractor;
import bkotyik.mobsoft2016.view.MainView;

public class MainPresenter extends Presenter<MainView> {

    @Inject
    public FloorInteractor interactor;

    public MainPresenter() {
        IndoorMapApplication.injector.inject(this);
    }

    public void doStuff() {
        view.showFloors(interactor.getFloors());
    }
}
