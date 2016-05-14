package bkotyik.mobsoft2016.interactor;

import android.content.Context;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public FloorInteractor getFloorInteractor() {
        return new FloorInteractor();
    }

    @Provides
    public EmployeeInteractor getEmployeeInteractor() {
        return new EmployeeInteractor();
    }
}
