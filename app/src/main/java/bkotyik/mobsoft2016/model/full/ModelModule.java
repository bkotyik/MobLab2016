package bkotyik.mobsoft2016.model.full;

import dagger.Module;
import dagger.Provides;

@Module
public class ModelModule {
    @Provides
    public EmployeeDbModel provideMockEmployeeDbModel() {
        return new EmployeeDbModel();
    }
    @Provides
    public FloorDbModel provideFloorDbModel() {
        return new FloorDbModel();
    }
}
