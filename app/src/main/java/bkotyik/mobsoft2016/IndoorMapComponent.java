package bkotyik.mobsoft2016;

import javax.inject.Singleton;

import bkotyik.mobsoft2016.interactor.EmployeeInteractor;
import bkotyik.mobsoft2016.interactor.FloorInteractor;
import bkotyik.mobsoft2016.interactor.InteractorModule;
import bkotyik.mobsoft2016.model.ModelModule;
import bkotyik.mobsoft2016.presenter.MainPresenter;
import bkotyik.mobsoft2016.view.EmployeeSearchActivity;
import bkotyik.mobsoft2016.view.FloorDetailsActivity;
import bkotyik.mobsoft2016.view.FloorEditorAcitivity;
import bkotyik.mobsoft2016.view.MainActivity;
import bkotyik.mobsoft2016.view.ViewModule;
import dagger.Component;


@Singleton
@Component( modules = {ViewModule.class, InteractorModule.class, ModelModule.class} )
public interface IndoorMapComponent {
    void inject(MainActivity mainActivity);
    void inject(FloorDetailsActivity floorDetailsActivity);
    void inject(EmployeeSearchActivity employeeSearchActivity);
    void inject(FloorEditorAcitivity floorEditorAcitivity);
    void inject(MainPresenter mainPresenter);
    void inject(FloorInteractor floorInteractor);
    void inject(EmployeeInteractor employeeInteractor);
}
