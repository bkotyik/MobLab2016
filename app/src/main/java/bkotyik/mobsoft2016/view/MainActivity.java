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
import android.widget.Toast;

import com.orm.SugarContext;

import java.util.List;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.R;
import bkotyik.mobsoft2016.adapters.FloorListAdapter;
import bkotyik.mobsoft2016.model.Floor;
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
        SugarContext.init(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachView(this);
        mainPresenter.activate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void showFloors(List<Floor> floors) {
        floorListView = (ListView)findViewById(R.id.floorListView);
        listAdapter = new FloorListAdapter(getApplicationContext(),floors);
        floorListView.setAdapter( listAdapter );
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG);
    }
}
