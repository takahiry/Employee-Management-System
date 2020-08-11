package com.takahiry.dao;

import com.takahiry.pojo.Department;
import com.takahiry.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//員工Dao
@Repository
public class EmployeeDao {

    //模擬數據庫中的數據
    private static Map<Integer, Employee> employees = null ;
    //員工有所屬部門
    @Autowired
    private DepartmentDao departmentDao ;
    static {
        employees = new HashMap<Integer, Employee>() ; //创建一个部门表

        employees.put(1001, new Employee(1001,"AA", "A1234@qq.com",1,new Department(101,"教學"))) ;
        employees.put(1002, new Employee(1002,"BB", "B1234@qq.com",0,new Department(102,"市場部"))) ;
        employees.put(1003, new Employee(1003,"CC", "C1234@qq.com",1,new Department(103,"教研部"))) ;
        employees.put(1004, new Employee(1004,"DD", "D1234@qq.com",0,new Department(104,"運營部"))) ;
        employees.put(1005, new Employee(1005,"EE", "E1234@qq.com",1,new Department(105,"後勤部"))) ;

    }

    //主鍵自增！
    private static Integer initId = 1006 ;
    //增加一個員工
    public void add(Employee employee) {
        if ( employee.getId() == null ) {
            employee.setId(initId++) ;
        }

        employee.setDepartment(departmentDao.getDepartmentById((employee.getDepartment().getId())));

        employees.put(employee.getId(),employee) ;
    }

    //查詢全部員工
    public Collection< Employee > getAll() {
        return employees.values() ;
    }

    //通過id查詢員工
    public Employee getEmployeeById(Integer id) {
        return employees.get(id) ;
    }

    //刪除員工
    public void delete(Integer id) {
        employees.remove(id) ;
    }
}
