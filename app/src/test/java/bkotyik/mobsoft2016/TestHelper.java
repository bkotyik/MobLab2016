package bkotyik.mobsoft2016;


import android.app.Application;

import org.robolectric.RuntimeEnvironment;

public class TestHelper {

    public static void setTestInjector() {
        IndoorMapApplication application = (IndoorMapApplication) RuntimeEnvironment.application;
        //IndoorMapComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        //application.setInjector(injector);
    }
}
