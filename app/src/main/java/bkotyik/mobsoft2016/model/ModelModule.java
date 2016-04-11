package bkotyik.mobsoft2016.model;

import dagger.Module;
import dagger.Provides;

@Module
public class ModelModule {
    @Provides
    public FloorModel getBuildingModel() {
        return new FloorModel();
    }
}
