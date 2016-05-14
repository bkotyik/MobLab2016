package bkotyik.mobsoft2016.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.R;
import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.presenter.FloorDetailsPresenter;
import bkotyik.mobsoft2016.presenter.MainPresenter;

public class FloorDetailsActivity extends Activity implements FloorDetailsView {
    @Inject
    FloorDetailsPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_details);
        IndoorMapApplication.injector.inject(this);

        Intent intent = getIntent();
        mainPresenter.loadFloor(intent.getIntExtra("FLOOR_ID",0));
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
    public void showFloorDetails(Floor m) {
        TextView tvFloorDetails = (TextView)findViewById(R.id.tvFloorDescription);
        tvFloorDetails.setText(m.getDescription());

        TextView tvFloorName = (TextView)findViewById(R.id.tvFloorName);
        tvFloorName.setText(m.getName());

    }

    @Override
    public void showEmployeeList(List<Employee> EmployeeList) {

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }
}
