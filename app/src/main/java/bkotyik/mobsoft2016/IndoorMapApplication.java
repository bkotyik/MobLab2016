package bkotyik.mobsoft2016;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import bkotyik.mobsoft2016.view.ViewModule;


public class IndoorMapApplication extends Application {

    public static IndoorMapComponent injector;
    private Tracker mTracker;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.FLAVOR.equals("mock")) {
            injector = DaggerMockIndoorMapComponent.builder().viewModule(new ViewModule(this)).build();
        } else {
            injector = DaggerIndoorMapComponent.builder().viewModule(new ViewModule(this)).build();
        }
    }

    public void setInjector(IndoorMapComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
    }

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }

}
