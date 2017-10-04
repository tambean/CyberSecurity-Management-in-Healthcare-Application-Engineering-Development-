/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author anike
 */
public class EmployeeDirectory {
    
     private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }
    
    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name,String id){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmailid(id);
        employee.setStatus("Active");
        employeeList.add(employee);
        return employee;
    }
    
     public void deleteEmployee(Employee p) {
        employeeList.remove(p);
    }
     
    public boolean checkIfUsernameIsUnique(String username) {
        for (Employee ua : employeeList) {
            if (ua.getName().equals(username)) {
                return false;
            }
        }
        return true;
    }
    
}
