package bkotyik.mobsoft2016.model;

import dagger.Module;
import dagger.Provides;

@Module
public class ModelModule {
    @Provides
    public Floor getBuildingModel() {
        return new Floor();
    }
    @Provides
    public Employee getEmployee() {
        return new Employee();
    }
}
