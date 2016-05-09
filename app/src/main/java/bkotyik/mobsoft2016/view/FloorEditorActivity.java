package bkotyik.mobsoft2016.view;

import android.app.Activity;
import android.os.Bundle;
import java.util.List;
import javax.inject.Inject;
import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.R;
import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.presenter.FloorEditorPresenter;

public class FloorEditorActivity extends Activity implements FloorEditorView {

    @Inject
    FloorEditorPresenter floorEditorPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_editor);
        IndoorMapApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        floorEditorPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        floorEditorPresenter.detachView();
    }

    @Override
    public void showFloorDetails(Floor Floor) {

    }

    @Override
    public void showEmployees(List<Employee> Employees) {

    }

    @Override
    public void showMessage(String msg) {

    }
}
