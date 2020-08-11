package com.takahiry.controller;

import com.takahiry.dao.DepartmentDao;
import com.takahiry.dao.EmployeeDao;
import com.takahiry.pojo.Department;
import com.takahiry.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao ;

    @Autowired
    DepartmentDao departmentDao ;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll() ;
        model.addAttribute("emps",employees) ;
        return "emp/list" ;
    }

    @GetMapping("/emp")
    public String toAddpage(Model model){
        //查出所有部門的信息
        Collection<Department> departments=departmentDao.getDepartment();
        System.out.println(departments);
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        //添加的操作
        employeeDao.add(employee) ; //調用底層業務方法保存員工信息

        return "redirect:/emps" ;
    }

    //員工的修改頁面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model) {
        //查出原來的數據
        Employee employee = employeeDao.getEmployeeById(id) ;

        model.addAttribute("emp",employee) ;
        //查出所有部門信息
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);

        return "emp/update" ;
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeDao.add(employee) ;
        return "redirect:/emps" ;
    }

    //刪除員工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") int id) {
        employeeDao.delete(id) ;
        return "redirect:/emps" ;
    }
}
