package bkotyik.mobsoft2016.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.R;
import bkotyik.mobsoft2016.adapters.FloorListAdapter;
import bkotyik.mobsoft2016.model.FloorModel;
import bkotyik.mobsoft2016.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView {

    private ListView floorListView = null;
    private FloorListAdapter listAdapter;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IndoorMapApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void showFloors(List<FloorModel> floors) {
        //floorListView = (ListView)findViewById(R.id.floorListView);
        //listAdapter = new FloorListAdapter(getApplicationContext(),floors);
        //floorListView.setAdapter( listAdapter );
    }
}
