package bkotyik.mobsoft2016.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.orm.SugarContext;

import java.util.List;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.R;
import bkotyik.mobsoft2016.adapters.FloorListAdapter;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.presenter.MainPresenter;

public class FloorListActivity extends android.support.v4.app.Fragment implements FloorListView {

    private ListView floorListView = null;
    private FloorListAdapter listAdapter;

    @Inject
    MainPresenter mainPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        IndoorMapApplication.injector.inject(this);
        return inflater.inflate(R.layout.activity_floor_list, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        mainPresenter.attachView(this);
        mainPresenter.activate();

        FloatingActionButton fab = (FloatingActionButton)getView().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.flContent, new FloorEditorActivity());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void showFloors(List<Floor> floors) {
        floorListView = (ListView)getView().findViewById(R.id.floorListView);
        listAdapter = new FloorListAdapter(getContext(),floors);
        floorListView.setAdapter( listAdapter );

        floorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Floor floor = (Floor)listAdapter.getItem(position);
                if (floor != null) {
                    FloorDetailsActivity newFragment = new FloorDetailsActivity();
                    Bundle args = new Bundle();
                    args.putLong("FLOOR_ID", floor.getId());
                    newFragment.setArguments(args);

                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                    transaction.replace(R.id.flContent, newFragment);
                    transaction.addToBackStack(null);

                    transaction.commit();

                }
            }
        });
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
    }
}
