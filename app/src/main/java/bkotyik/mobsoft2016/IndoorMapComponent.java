package bkotyik.mobsoft2016;

import javax.inject.Singleton;

import bkotyik.mobsoft2016.interactor.EmployeeInteractor;
import bkotyik.mobsoft2016.interactor.FloorInteractor;
import bkotyik.mobsoft2016.interactor.InteractorModule;
import bkotyik.mobsoft2016.model.full.ModelModule;
import bkotyik.mobsoft2016.network.prod.NetworkModule;
import bkotyik.mobsoft2016.presenter.EmployeeSearchPresenter;
import bkotyik.mobsoft2016.presenter.FloorDetailsPresenter;
import bkotyik.mobsoft2016.presenter.FloorEditorPresenter;
import bkotyik.mobsoft2016.presenter.MainPresenter;
import bkotyik.mobsoft2016.view.EmployeeSearchActivity;
import bkotyik.mobsoft2016.view.FloorDetailsActivity;
import bkotyik.mobsoft2016.view.FloorEditorActivity;
import bkotyik.mobsoft2016.view.FloorListActivity;
import bkotyik.mobsoft2016.view.ViewModule;
import dagger.Component;


@Singleton
@Component( modules = {ViewModule.class, InteractorModule.class, ModelModule.class, NetworkModule.class} )
public interface IndoorMapComponent {
    void inject(FloorListActivity floorListActivity);
    void inject(FloorDetailsActivity floorDetailsActivity);
    void inject(EmployeeSearchActivity employeeSearchActivity);
    void inject(FloorEditorActivity floorEditorAcitivity);
    void inject(MainPresenter mainPresenter);
    void inject(FloorInteractor floorInteractor);
    void inject(EmployeeInteractor employeeInteractor);
    void inject(FloorDetailsPresenter floorDetailsPresenter);
    void inject(FloorEditorPresenter floorEditorPresenter);
    void inject(IndoorMapApplication indoor);
    void inject(EmployeeSearchPresenter indoor);
}
