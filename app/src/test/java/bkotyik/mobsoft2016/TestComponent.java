package bkotyik.mobsoft2016;

import javax.inject.Singleton;

import bkotyik.mobsoft2016.interactor.InteractorModule;
import bkotyik.mobsoft2016.network.mock.MockNetworkModule;
import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class})
public interface TestComponent  {
}
