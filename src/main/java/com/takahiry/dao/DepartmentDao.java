package com.takahiry.dao;

import com.takahiry.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部分dao
@Repository
public class DepartmentDao {

    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null ;
    static {
        departments = new HashMap<Integer, Department>() ; //创建一个部门表

        departments.put(101, new Department(101,"教学部")) ;
        departments.put(102, new Department(102,"市場部")) ;
        departments.put(103, new Department(103,"教研部")) ;
        departments.put(104, new Department(104,"運營部")) ;
        departments.put(105, new Department(105,"後勤部")) ;

    }

    //獲得所有部分信息
    public Collection<Department> getDepartment() {
        return departments.values() ;
    }

    //通過id得到部門
    public Department getDepartmentById(Integer id) {
        return departments.get(id) ;
    }

}
