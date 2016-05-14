package bkotyik.mobsoft2016.model.mock;

import bkotyik.mobsoft2016.model.full.EmployeeDbModel;
import bkotyik.mobsoft2016.model.full.FloorDbModel;
import dagger.Module;
import dagger.Provides;

@Module
public class MockModelModule {
    @Provides
    public EmployeeDbModel provideMockEmployeeDbModel() {
        return new MockEmployeeDbModel();
    }
    @Provides
    public FloorDbModel provideFloorDbModel() {
        return new MockFloorDbModel();
    }
}
