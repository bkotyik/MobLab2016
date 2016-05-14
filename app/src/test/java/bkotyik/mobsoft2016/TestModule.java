package bkotyik.mobsoft2016;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;


import bkotyik.mobsoft2016.model.full.ModelModule;
import bkotyik.mobsoft2016.presenter.MainPresenter;
import bkotyik.mobsoft2016.view.ViewModule;
import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {

    private final ViewModule viewModule;
    private final ModelModule modelModule;

    public TestModule(Context context) {

        this.viewModule = new ViewModule(context);
        this.modelModule = new ModelModule();
    }

    @Provides
    public Context provideContext() {
        return viewModule.provideContext();
    }

}
