package bkotyik.mobsoft2016.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bkotyik.mobsoft2016.R;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.view.MainActivity;

public class FloorListAdapter extends BaseAdapter {

    private LayoutInflater mInflater = null;
    private List<Floor> floorList;
    private Context mContext;

    private final class ViewHolder {
        TextView nameTextView;
    }

    private ViewHolder mHolder = null;


    public FloorListAdapter(Context context, List<Floor> floors) {
        this.floorList = floors;
        mContext = context;
        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return floorList.size();
    }

    @Override
    public Object getItem(int position) {
        return floorList.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            mHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.floor_row, null);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder)convertView.getTag();
        }

        mHolder.nameTextView = (TextView)convertView.findViewById(R.id.name_textView);
        mHolder.nameTextView.setText(floorList.get(position).getName());

        return convertView;
    }
}
