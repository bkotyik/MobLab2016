package bkotyik.mobsoft2016;

import javax.inject.Singleton;

import bkotyik.mobsoft2016.interactor.InteractorModule;
import bkotyik.mobsoft2016.interactor.StringInteractor;
import bkotyik.mobsoft2016.model.ModelModule;
import bkotyik.mobsoft2016.presenter.MainPresenter;
import bkotyik.mobsoft2016.view.MainActivity;
import bkotyik.mobsoft2016.view.ViewModule;
import dagger.Component;


@Singleton
@Component( modules = {ViewModule.class, InteractorModule.class, ModelModule.class} )
public interface IndoorMapComponent {
    void inject(MainActivity mainActivity);
    void inject(MainPresenter mainPresenter);
    void inject(StringInteractor stringInteractor);
}