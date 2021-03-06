package bkotyik.mobsoft2016.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import bkotyik.mobsoft2016.R;
import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.Floor;

public class EmployeeListAdapter extends BaseAdapter {

    private LayoutInflater mInflater = null;
    private List<Employee> employeeList;
    private Context mContext;

    private final class ViewHolder {
        TextView nameTextView;
        TextView roomNumberTextView;
    }

    private ViewHolder mHolder = null;


    public EmployeeListAdapter(Context context, List<Employee> employees) {
        this.employeeList = employees;
        mContext = context;
        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return employeeList.size();
    }

    @Override
    public Object getItem(int position) {
        return employeeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            mHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.employee_row, null);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder)convertView.getTag();
        }

        mHolder.nameTextView = (TextView)convertView.findViewById(R.id.name_textView);
        mHolder.nameTextView.setText(employeeList.get(position).getName());

        mHolder.roomNumberTextView = (TextView)convertView.findViewById(R.id.roomNumber_textView);
        mHolder.roomNumberTextView.setText(employeeList.get(position).getRoomNumber());

        return convertView;
    }

    public void remove(int position) {
        this.employeeList.remove(position);
        this.notifyDataSetChanged();
    }
}
