package bkotyik.mobsoft2016;

import android.app.Application;
import bkotyik.mobsoft2016.view.ViewModule;


public class IndoorMapApplication extends Application {

    public static IndoorMapComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerIndoorMapComponent.builder().viewModule(new ViewModule(this)).build();
    }
}
