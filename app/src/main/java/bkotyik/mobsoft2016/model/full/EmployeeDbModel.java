package bkotyik.mobsoft2016.model.full;

import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

import bkotyik.mobsoft2016.model.Employee;

public class EmployeeDbModel {

    public List<Employee> fetch() {
        List<Employee> values = Employee.listAll(Employee.class);
        return values;
    }

    public void insert(Employee toInsert) {
        toInsert.save();
    }

    public List<Employee> fetchByFloorId(long id) {
        return Select.from(Employee.class)
                .where(Condition.prop("floor_id").eq((int)id))
                .list();
    }

    public List<Employee> fetchByEmployeeName(String name) {
        return Employee.find(Employee.class,"name = ?", name);
    }

    public void removeByFloorId(Long id) {
        Employee.deleteAll(Employee.class, "floor_id = ?", id.toString());
    }
}
