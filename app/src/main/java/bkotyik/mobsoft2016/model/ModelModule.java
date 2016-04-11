package bkotyik.mobsoft2016.model;

import dagger.Module;
import dagger.Provides;

@Module
public class ModelModule {
    @Provides
    public StringModel getStringModel() {
        return new StringModel();
    }
}
