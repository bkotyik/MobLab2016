package bkotyik.mobsoft2016.presenter;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.interactor.FloorInteractor;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.view.MainView;

public class MainPresenter extends Presenter<MainView> {

    @Inject
    public FloorInteractor interactor;

    public MainPresenter() {

    }

    public void activate() {
        view.showFloors(interactor.getFloorsFromDb());
    }
    public void selectFloor(Floor Floor) {}
    public void addFloor() {}
}
