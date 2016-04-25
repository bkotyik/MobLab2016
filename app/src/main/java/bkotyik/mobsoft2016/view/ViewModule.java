package bkotyik.mobsoft2016.view;

import android.content.Context;

import javax.inject.Singleton;

import bkotyik.mobsoft2016.presenter.FloorDetailsPresenter;
import bkotyik.mobsoft2016.presenter.MainPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {
    private Context context;

    public ViewModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter getMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public FloorDetailsPresenter getFloorDetailsPresenter() {
        return new FloorDetailsPresenter();
    }
}
