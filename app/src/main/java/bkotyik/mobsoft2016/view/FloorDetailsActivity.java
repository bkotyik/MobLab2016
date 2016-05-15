package bkotyik.mobsoft2016.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.R;
import bkotyik.mobsoft2016.adapters.EmployeeListAdapter;
import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.presenter.FloorDetailsPresenter;
import bkotyik.mobsoft2016.presenter.MainPresenter;

public class FloorDetailsActivity extends Activity implements FloorDetailsView {
    @Inject
    FloorDetailsPresenter presenter;

    ImageButton btnDeleteFloor = null;
    ImageButton btnEditFloor = null;

    ListView employeeListView = null;
    EmployeeListAdapter listAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_details);
        IndoorMapApplication.injector.inject(this);

        btnDeleteFloor = (ImageButton)findViewById(R.id.btnDeleteFloor);
        btnDeleteFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(FloorDetailsActivity.this)
                        .setMessage("Tényleg törlöd az emeletet?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                presenter.deleteFloor();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();

            }
        });

        btnEditFloor = (ImageButton)findViewById(R.id.btnEditFloor);
        btnEditFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FloorEditorActivity.class);
                //intent.putExtra("FLOOR_ID", floor.getId());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);

        Intent intent = getIntent();
        presenter.loadFloor(intent.getIntExtra("FLOOR_ID",0));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
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
        employeeListView = (ListView)findViewById(R.id.lvEmployees);
        listAdapter = new EmployeeListAdapter(getApplicationContext(),EmployeeList);
        employeeListView.setAdapter( listAdapter );
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }
}
