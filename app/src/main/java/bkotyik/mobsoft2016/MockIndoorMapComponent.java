package bkotyik.mobsoft2016;

import javax.inject.Singleton;;
import bkotyik.mobsoft2016.interactor.InteractorModule;
import bkotyik.mobsoft2016.model.mock.MockModelModule;
import bkotyik.mobsoft2016.network.mock.MockNetworkModule;
import bkotyik.mobsoft2016.view.ViewModule;
import dagger.Component;

@Singleton
@Component( modules = {ViewModule.class, InteractorModule.class, MockNetworkModule.class, MockModelModule.class} )
public interface MockIndoorMapComponent extends IndoorMapComponent {

}
