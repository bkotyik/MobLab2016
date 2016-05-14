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
        IndoorMapApplication.injector.inject(this);
    }

    public void activate() {
        try {
            view.showFloors(interactor.getFloorsFromNetwork());
        } catch (Exception e) {
            view.showFloors(interactor.getFloorsFromDb());
            view.showMessage(e.getMessage());
        }
    }
    public void selectFloor(Floor Floor) {}
    public void addFloor() {}
}
